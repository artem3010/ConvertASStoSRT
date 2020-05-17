import java.util.ArrayList;
import java.util.List;

public class Separator {
    public static enum tumbler {
        FIRSTLINE,
        NOTFIRSTLINE,
    }
    public static List<String> separateOnLines(String string){
        char[] tempChar = string.toCharArray();
        List<String> list = new ArrayList<>();
        String temp="";
        for (char ch :tempChar ) {
            if(ch!='\n'){
                temp+=ch;
            } else {
                list.add(temp);
                temp ="";
            }
        }
        return list;
    }

    public static List<StringBuffer> separateDialogue(List<String> strings ) {
        tumbler arg = tumbler.FIRSTLINE;
        List<StringBuffer> list = new ArrayList<>();
        int count = -1;
        for (int i = 0; i<strings.size(); i++ ) {
            if (arg == tumbler.FIRSTLINE) {
                list.add(new StringBuffer(strings.get(i)));
                arg = tumbler.NOTFIRSTLINE;
                if (i+1<strings.size()) {
                    arg = (strings.get(i + 1).indexOf("Dialogue:") != -1) ? tumbler.FIRSTLINE : tumbler.NOTFIRSTLINE;
                }
                count++;
            } else if (arg== tumbler.NOTFIRSTLINE ){
                list.get(count).append(" "+strings.get(i));
                if (i+1<strings.size()){
                    arg = (strings.get(i+1).indexOf("Dialogue:")!=-1)? tumbler.FIRSTLINE:tumbler.NOTFIRSTLINE;
                }
            }
        }
        return list;
    }
}
