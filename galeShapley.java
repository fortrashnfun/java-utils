import java.util.*;
public class galeShapley {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of pairs 'n':");
        int n = in.nextInt();
        int[][] menPref = new int[n][n];
        int[][] womenPref = new int[n][n];
        System.out.println("Enter men's preferences:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                menPref[i][j] = in.nextInt();
            }
        }
        System.out.println("Enter women's preferences:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                womenPref[i][j] = in.nextInt();
            }
        }
        int[] result = stableMatching(menPref,womenPref,n);
        System.out.println("Stable matching:");
        for(int i=0;i<n;i++){
            System.out.println("Women" + i + " is matched with Man" + result[i]);
        }
    }
    static int[] stableMatching(int[][] menPref, int[][] womenPref, int n){
        int[] womenPartner = new int[n];
        Arrays.fill(womenPartner,-1);
        boolean[] menFree = new boolean[n];
        Arrays.fill(menFree,true);
        int[] nextProposal = new int[n];
        //while there exist a free man who has not proposed to all women
        while(true){ 
            int m = -1;
            //pick a free man m
            for(int i=0;i<n;i++){
                if(menFree[i]){
                    m = i;
                    break;
                }
            }
            //if no free man exists -> stop / break
            if(m==-1) break;
            //w=highest ranked women in m's preference list to whom m has not yet proposed
            int w = menPref[m][nextProposal[m]];
            nextProposal[m]++;
            //if w is free -> (m,w) become partners
            if(womenPartner[w]==-1){
                womenPartner[w] = m;
                menFree[m] = false;
            }
            else{
                //if m' is w's current partner
                int currentPartner = womenPartner[w];
                //if we prefers m over currentPartner m' -> (m,w) become partners and m' becomes free
                if(prefers(womenPref[w],m,currentPartner)){
                    womenPartner[w] = m;
                    menFree[currentPartner] = true;
                    menFree[m] = false;
                }
                //else w rejects m and m remains free
            }
        }
        return womenPartner;
    }
    static boolean prefers(int[] pref, int m, int currentPartner){
        for(int x: pref){
            if(x==m) return true;
            if(x==currentPartner) return false;
        }
        return false; // This line should never be reached if the input is valid
    }
}