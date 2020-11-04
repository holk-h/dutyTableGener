import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.component.VEvent;

import java.io.FileInputStream;
import java.io.IOException;

public class dutyTableGener {

    public static int getSeq(String t) {
        int seq = 0;
        if ("0800".equals(t)) {
            seq = 1;
        } else if ("1010".equals(t)) {
            seq = 2;
        } else if ("1430".equals(t) || "1400".equals(t)) {
            seq = 3;
        } else if ("1640".equals(t) || "1610".equals(t)) {
            seq = 4;
        } else if ("1930".equals(t) || "1900".equals(t)) {
            seq = 5;
        }
        return seq;
    }

    public static void importFile() throws IOException, ParserException {

        FileInputStream fis = new FileInputStream("B562ADFC2275469896B08C77AE2ADC3D.ics");
        CalendarBuilder build = new CalendarBuilder();
        Calendar calendar = build.build(fis);
        int [][] week = new int[5][5];

        for (Object o : calendar.getComponents(Component.VEVENT)) {
            VEvent event = (VEvent) o;
            String[] beginTime = event.getStartDate().getValue().split("T");
            int weekSeq = util.getWeek(beginTime[0]);
            int classSeq = getSeq(beginTime[1].substring(0, 4));

//            System.out.println("week:" + weekSeq);
//            System.out.println("seq:" + classSeq);

//            System.out.println("end" + event.getEndDate().getValue());
//            if (null != event.getProperty("DTSTART")) {
//                ParameterList parameters = event.getProperty("DTSTART").getParameters();
//                if (null != parameters.getParameter("VALUE")) {
//                    System.out.println(parameters.getParameter("VALUE").getValue());
//                }
//            }
//            // 主题
//            System.out.println("主题：" + event.getSummary().getValue());
//            // 地点
//            if (null != event.getLocation()) {
//                System.out.println("地点：" + event.getLocation().getValue());
//            }
//            // 描述
//            if (null != event.getDescription()) {
//                System.out.println("描述：" + event.getDescription().getValue());
//            }
//            // 创建时间
//            if (null != event.getCreated()) {
//                System.out.println("创建时间：" + event.getCreated().getValue());
//            }
//            // 最后修改时间
//            if (null != event.getLastModified()) {
//                System.out.println("最后修改时间：" + event.getLastModified().getValue());
//            }
//            // 重复规则
//            if (null != event.getProperty("RRULE")) {
//                System.out.println("RRULE:" + event.getProperty("RRULE").getValue());
//            }
//            // 提前多久提醒
//            for (Iterator alrams = event.getAlarms().iterator(); alrams.hasNext(); ) {
//                VAlarm alarm = (VAlarm) alrams.next();
//                Pattern p = Pattern.compile("[^0-9]");
//                String aheadTime = alarm.getTrigger().getValue();
//                Matcher m = p.matcher(aheadTime);
//                int timeTemp = Integer.valueOf(m.replaceAll("").trim());
//                if (aheadTime.endsWith("W")) {
//                    System.out.println("提前多久：" + timeTemp + "周");
//                } else if (aheadTime.endsWith("D")) {
//                    System.out.println("提前多久：" + timeTemp + "天");
//                } else if (aheadTime.endsWith("H")) {
//                    System.out.println("提前多久：" + timeTemp + "小时");
//                } else if (aheadTime.endsWith("M")) {
//                    System.out.println("提前多久：" + timeTemp + "分钟");
//                } else if (aheadTime.endsWith("S")) {
//                    System.out.println("提前多久：" + timeTemp + "秒");
//                }
//            }
//            // 邀请人
//            if (null != event.getProperty("ATTENDEE")) {
//                ParameterList parameters = event.getProperty("ATTENDEE").getParameters();
//                System.out.println(event.getProperty("ATTENDEE").getValue().split(":")[1]);
//                System.out.println(parameters.getParameter("PARTSTAT").getValue());
//            }
//            System.out.println("----------------------------");

            week[weekSeq-1][classSeq-1] = 1;
        }
//        System.out.println(Arrays.deepToString(week));
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (week[i][j] == 0){
                    System.out.print("第"+(i+1)+"周"+"第"+(j+1)+"节"+" ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, ParserException {
        importFile();
    }
}
