import java.util.*;
import java.io.*;

class Solution {
    static class Subject {
        String name;
        int remainTime;
        public Subject(String name, int remainTime) {
            this.name = name;
            this.remainTime = remainTime;
        }
    }
    
    static Subject[] subjects;
    static Subject[] existSubject;
    static int n;
    
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        Arrays.sort(plans, (x,y) -> convert(x[1]) - convert(y[1]));
        
        Stack<Subject> progressing = new Stack<>();
        
        for(int i=0;i<plans.length;i++){
            String name = plans[i][0];
            int startTime = convert(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            
            if(i==plans.length - 1)
                answer.add(name);
            else {
                int nextTime = convert(plans[i+1][1]);
                int remainTime = nextTime - startTime;
                
                progressing.push(new Subject(name,playTime));
                
                while(!progressing.isEmpty() && remainTime > 0) {
                    Subject curSubject = progressing.pop();
                    int played = Math.min(remainTime, curSubject.remainTime);
                    
                    if(played==curSubject.remainTime)
                        answer.add(curSubject.name);
                    else
                        progressing.add(new Subject(curSubject.name,curSubject.remainTime - played));
                    remainTime-=played;
                }
            }
        }
        
        while(!progressing.isEmpty()){
            answer.add(progressing.pop().name);
        }
        
        return answer.toArray(String[]::new);
    }
    
    public int convert(String time) {
        String[] rawTime = time.split(":");
        return Integer.parseInt(rawTime[0]) * 60 + Integer.parseInt(rawTime[1]);
    }
}