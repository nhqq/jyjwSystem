package cdu.jyjw.util;

import com.sun.deploy.util.ArrayUtil;
import org.junit.Test;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Pattern;

public class StrUtil {
    /**
     * 对数据库中的week字符串进行格式化
     *
     * @param str
     * @return
     */
    public static String weekUtils(String str) {
        if (Objects.equals(str, "未设置")) {
            return str;
        }
        StringBuffer week = new StringBuffer();
        String[] split1 = str.split("、");
        for (int j = 0; j < split1.length; j++) {
            String[] split2 = split1[j].split("&");
            if (split2 != null) {
                switch (split2[0]) {
                    case "1":
                        split2[0] = "星期一";
                        break;
                    case "2":
                        split2[0] = "星期二";
                        break;
                    case "3":
                        split2[0] = "星期三";
                        break;
                    case "4":
                        split2[0] = "星期四";
                        break;
                    case "5":
                        split2[0] = "星期五";
                        break;
                    case "6":
                        split2[0] = "星期六";
                        break;
                    case "7":
                        split2[0] = "星期日";
                        break;
                }
                switch (split2[1]) {
                    case "1":
                        split2[1] = "第一节";
                        break;
                    case "2":
                        split2[1] = "第二节";
                        break;
                    case "3":
                        split2[1] = "第三节";
                        break;
                    case "4":
                        split2[1] = "第四节";
                        break;
                    case "5":
                        split2[1] = "第五节";
                        break;
                }
            }
            for (String value : split2) {
                week.append(value);
            }
            for (int i = 0; i < split2.length; i = 1 + 2) {
                week.append("、");
            }
        }
        String weekStr = String.valueOf(week);
        return weekStr.substring(0, weekStr.length() - 1);
    }

    /**
     * 对timeFinish进行格式化
     *
     * @param finishTime
     * @return
     */
    public static String finishUtils(String finishTime) {
        if (Objects.equals(finishTime, "未设置")) {
            return finishTime;
        }
        StringBuffer finish = new StringBuffer();
        String[] split1 = finishTime.split("&");
        split1[0] = split1[0] + "年";
        split1[1] = "第" + split1[1] + "周";
        for (String s : split1) {
            finish.append(s);
        }
        return String.valueOf(finish);
    }

    /**
     * 将前端的week与该老师的数据库存储的week进行对比
     *
     * @param weekStr
     * @return
     */
    public static boolean week2Utils(String weekStr, String dateWeek) {
        if (weekStr.equals("未设置")) {
            return true;
        }
        if (dateWeek==null&&dateWeek.equals("")){
            return true;
        }
        String[] weekStrSplit = weekStr.split("、");
        String[] dateWeekSplit = dateWeek.split("、");
        boolean flag = false;
        HashSet<String> set = new HashSet<>(Arrays.asList(weekStrSplit));
        set.retainAll(Arrays.asList(dateWeekSplit));
        if (set.size() == 0) {
            flag = true;
        } else {
            System.out.println("时间冲突");
        }
        if (!flag) {
            System.out.println("时间冲突");
        }
        return flag;
    }

    /**
     * 判断成绩是否符合要求，必须是数字、三位数以下
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (str != null && !str.trim().equals("")) {
            Pattern pattern = Pattern.compile("[0-9]*");
            return pattern.matcher(str).matches();
        } else {
            return false;
        }
    }
    public static boolean isLength(String score){
        return Integer.parseInt(score) <= 100;
    }
}
