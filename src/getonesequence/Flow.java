package getonesequence;
import java.io.*;
/**
 * <p>Title: </p>
 *
 * <p>Description: ��negfamily�ļ�����ÿ���ļ��г�ȡ������У�д��һ�����ļ�neg.fasta��</p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: </p>
 *
 * @author ��Ȩ
 * @version 1.0
 */
public class Flow {
    public Flow() {
    }
    public void run(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("neg.fasta"));
            File f =  new File("negfamily");
            File[] list = f.listFiles();
            for(int i=0;i<list.length;i++){
                BufferedReader br = new BufferedReader(new FileReader(list[i]));
                String line = br.readLine();
                String name_last="",seq_last="";
            while (br.ready()) {
                if (line.length() != 0 && line.charAt(0) == '>') {
                    String name = line;
                    StringBuffer sb = new StringBuffer();
                    line = br.readLine();
                    while(br.ready()&&line.length()==0)
                        line = br.readLine();
                    while (line.length() != 0 && line.charAt(0) != '>') {
                        sb.append(line);
                        if (br.ready()) {
                            line = br.readLine();
                        } else {
                            break;
                        }
                    }
                    String seq = sb.toString();
                    if(seq.length()>seq_last.length()){
                        name_last=name;
                        seq_last=seq;
                    }

                } else {
                    line = br.readLine();
                }
            }

                br.close();
                bw.write(name_last);
                bw.newLine();
                bw.write(seq_last);
                bw.newLine();
                bw.flush();
            }
            bw.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
