package mock.coupa;

import com.fasterxml.jackson.core.JsonProcessingException;
import mock.coupa.requisition.Approval;
import mock.coupa.requisition.Approver;
import mock.coupa.requisition.Commodity;
import mock.coupa.requisition.Currency;
import mock.coupa.requisition.RequisitionHeader;
import mock.coupa.requisition.RequisitionHeaders;
import mock.coupa.requisition.RequisitionLine;
import mock.coupa.requisition.RequisitionLines;
import mock.coupa.requisition.Total;
import mock.coupa.requisition.User;
import mock.coupa.requisition.Users;
import mock.coupa.util.DataUtil;
import mock.coupa.util.RandomUtil;
import mock.coupa.util.XmlUtil;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.Collections.singletonList;

public class CoupaRequisitionGenerator
{
    static Map<String, Integer> USER_ID_MAP = new HashMap<>();

    public String generateRandomRequisitions(int id, int count) throws JsonProcessingException {
        RequisitionHeaders headers = new RequisitionHeaders();
        IntStream.range(0, count).forEach(couter -> {
            headers.requisitionHeader.add(randomRequisitionHeader(id + couter));
        });
        return XmlUtil.serialize(headers, "requisition-headers");
    }
    private RequisitionHeader randomRequisitionHeader(int id) {
        String requestor = RandomUtil.randomRequestor();
        String requestorName = requestor.substring(0, requestor.indexOf('@'));
        String requestorCompany = requestor.substring(requestor.indexOf('@') + 1);

        String approver = RandomUtil.randomApprover();
        String approverName = approver.substring(0, approver.indexOf('@'));
        String approverCompany = approver.substring(approver.indexOf('@') + 1);

        USER_ID_MAP.putIfAbsent(requestor, RandomUtils.nextInt(1000,9000));
        USER_ID_MAP.putIfAbsent(approver, RandomUtils.nextInt(1000, 9000));

        return RequisitionHeader.builder()
            .id(DataUtil.id(id))
            .createdAt(DataUtil.timestamp())
            .updatedAt(DataUtil.timestamp())
            .submittedAt(DataUtil.timestamp())
            .currency(Currency.builder().build())
            .total(Total.builder()
                .amt(RandomUtils.nextFloat())
                .build())
            .requisitionDescription("requisitionDescription")
            .requestorsCostCenter("requestorsCostCenter")
            .requestedBy(User.builder()
                .id(DataUtil.id(USER_ID_MAP.get(requestor)))
                .login(requestorName)
                .company(requestorCompany)
                .fullname(requestorName)
                .email(requestor)
                .build())
            .requisitionLines(RequisitionLines.builder()
                .requisitionLineList(singletonList(RequisitionLine.builder()
                    .id(DataUtil.id(id))
                    .createdAt(DataUtil.timestamp())
                    .description("description")
                    .total(Total.builder()
                        .amt(RandomUtils.nextFloat())
                        .build())
                    .commodity(Commodity.builder()
                        .id(DataUtil.id(id))
                        .createdAt(DataUtil.timestamp())
                        .updatedAt(DataUtil.timestamp())
                        .name("CommodityName")
                        .build())
                    .build()))
                .build())
            .currentApproval(Approval.builder()
                .id(DataUtil.id(id))
                .createdAt(DataUtil.timestamp())
                .updatedAt(DataUtil.timestamp())
                .approver(Approver.builder()
                    .id(DataUtil.id(id))
                    .createdAt(DataUtil.timestamp())
                    .updatedAt(DataUtil.timestamp())
                    .users(Users.builder()
                        .userList(singletonList(User.builder()
                            .id(DataUtil.id(USER_ID_MAP.get(approver)))
                            .login(approverName)
                            .company(approverCompany)
                            .firstname(approverName)
                            .lastname(approverName)
                            .fullname(approverName)
                            .email(approver)
                            .build()))
                        .build())
                    .build())
                .build())
            .build();

    }
}

