package mock.coupa;

import mock.coupa.util.PropertyUtil;
import org.apache.commons.io.IOUtils;
import org.mockserver.client.MockServerClient;
import org.mockserver.configuration.ConfigurationProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class App
{

    public static void main( String[] args ) throws IOException {
        ConfigurationProperties.maxSocketTimeout(TimeUnit.MINUTES.toMillis(2));
        MockServerClient mockServerClient = new MockServerClient(PropertyUtil.getProperty("mock.server.host"),
            Integer.parseInt(PropertyUtil.getProperty("mock.server.port")));
        mockServerClient.reset();
        mockCoupa(mockServerClient);
    }

    private static void mockCoupa(MockServerClient mockServerClient) throws IOException {
        int id = Integer.parseInt(PropertyUtil.getProperty("requisition.id.start"));
        int count = Integer.parseInt(PropertyUtil.getProperty("number.of.requisitions"));
        int offset = 0;
        int paginationCount = 50;

        while(count > 0) {
            int numReq = count > paginationCount? paginationCount : count;
            String data = new CoupaRequisitionGenerator().generateRandomRequisitions(id, numReq);
            System.out.println(offset + " -> " + data);
            mockServerClient
                .when(request()
                    .withQueryStringParameter("offset", Integer.toString(offset * 50))
                    .withMethod("GET")
                    .withPath("/api/requisitions"))
                .respond(response()
                    .withStatusCode(200)
                    .withBody(data));

            count -= paginationCount;
            id += paginationCount;
            offset +=1;
        }

        InputStream is = App.class.getClassLoader().getResourceAsStream("CoupaEmpty.xml");
        mockServerClient
            .when(request()
                .withMethod("GET")
                .withPath("/api/requisitions"))
            .respond(response()
                .withStatusCode(404)
                .withBody(IOUtils.toString(is, UTF_8)));
    }
}

