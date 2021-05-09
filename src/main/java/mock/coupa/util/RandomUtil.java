package mock.coupa.util;

import org.apache.commons.lang3.RandomUtils;

public class RandomUtil {

    private static String REQUESTORS[] = PropertyUtil.getProperty("requisition.requester.email.ids").split(",");
    private static String APPROVERS[] = PropertyUtil.getProperty("requisition.approver.email.ids").split(",");

    static {

    }
    public static String randomRequestor() {
        return REQUESTORS[RandomUtils.nextInt(0,REQUESTORS.length)];
    }

    public static String randomApprover() {
        return APPROVERS[RandomUtils.nextInt(0,APPROVERS.length)];
    }
}
