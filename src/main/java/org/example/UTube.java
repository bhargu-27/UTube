package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class UTube {
    ArrayList<String> uTube;
    int length;
    int mid;
    UTube(int length){
        this.length=length;
        this.mid = (length-1)/2;
        this.uTube=new ArrayList<>(Collections.nCopies(length, ""));
    }
    void addElementosLeft(String value){
            boolean isFilled = false;
            for (int i = mid; i >= 0; i--) {
                if (Objects.equals(uTube.get(i), "")) {
                    uTube.add(i, value);
                    isFilled = true;
                    break;
                }
            }
            if (!isFilled) {
                Collections.rotate(uTube, 1);
                uTube.add(0, value);
            }
    }
    void addElementosRight(String value){
            boolean isFilled = false;
            for (int i = mid; i < length; i++) {
                if (Objects.equals(uTube.get(i), "")) {
                    uTube.add(i, value);
                    isFilled = true;
                    break;
                }
            }
            if (!isFilled) {
                Collections.rotate(uTube, -1);
                uTube.add(length, value);
            }
        reBalanceTube();
    }
    ArrayList<String> getUTube(){
        return uTube;
    }
    void printUTube(){
        for(int i=0;i<mid;i++){
            System.out.println(uTube.get(i)+"\t"+uTube.get(length-i-1));
        }
        System.out.println("\t"+uTube.get(mid));
    }
    void reBalanceTube(){
        int balancePosition = uTubeBalancePosition();
        if(balancePosition==1){
            Collections.rotate(uTube,1);
        } else if(balancePosition==-1){
            Collections.rotate(uTube,-1);
        }
    }
    int uTubeBalancePosition(){
        int l=mid,r=mid;
        int leftHeight,rightHeight;
        while((l>=0 && r<=length)&&(uTube.get(l)!=null || uTube.get(r)!=null)){
            if(uTube.get(l)!=null) {
                l--;
            }
            if(uTube.get(r)!=null) {
                r++;
            }
        }
        leftHeight=mid-l-1;
        rightHeight=r-mid-1;
        if(leftHeight-rightHeight>1){
            return 1;
        } else if(rightHeight-leftHeight>1){
            return -1;
        } else {
            return 0;
        }
    }
}
