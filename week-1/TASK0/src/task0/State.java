
package task0;

import java.util.*;


public class State {
    
	public int[] obj;
        public int[] pstn;
	
	public State(){
            
            
		obj = new int[3];
                pstn=new int[3];
                
		obj[0] = obj[1] = obj[2] = 0;
                
                pstn[0]=1;
                pstn[1]=2;
                pstn[2]=3;
	}
        
        
	public State(int a, int b, int c,int pstna,int pstnb,int pstnc) {
            
		obj = new int[3];
                pstn=new int[3];
                
		obj[0] = a;
		obj[1] = b;
		obj[2] = c;
                
                pstn[0]=pstna;
                pstn[1]=pstnb;
                pstn[2]=pstnc;
                

	}
        
	
	public State[] generateNextState()
	{
		State ret[] = new State[6];
                int count=0;
                
                for(int i=0;i<=5;i++)
                {
                     ret[i]=new State(obj[0],obj[1],obj[2],pstn[0],pstn[1],pstn[2]);
                }
                
                
                for(int i=0;i<3;i++)
                {

               
                    if(pstn[i]==1)
                    {
                        if(obj[i]==0)
                        {
                            ret[count].obj[i]=1;
                            ret[count].pstn[i]=1;
                            
                            int z=0;
                            
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[count].obj[j]==0)
                                {
                                    ret[count].pstn[j]--;
                                }
                            }
                            
                            z=0; 
                            
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[count].obj[j]==1)
                                {
                                    ret[count].pstn[j]++;
                                }
                            }
                            
                            z=0;
                            count++;
                          
                            ret[count].obj[i]=2;
                            ret[count].pstn[i]=1;
                            
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[count].obj[j]==0)
                                {
                                    ret[count].pstn[j]--;
                                }
                            }
                            
                            z=0; 
                            
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[count].obj[j]==2)
                                {
                                    ret[count].pstn[j]++;
                                }
                            }
                            
                            z=0;
                            
                            count++;
                        }
                        
                        else if(obj[i]==1)
                        {
                            ret[count].obj[i]=0;
                            ret[count].pstn[i]=1;
                            
                            int z=0;
                            
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[count].obj[j]==1)
                                {
                                    ret[count].pstn[j]--;
                                }
                            }
                            
                            z=0; 
                            
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[count].obj[j]==0)
                                {
                                    ret[count].pstn[j]++;
                                }
                            }
                            
                            z=0;
                            count++;
                          
                            ret[count].obj[i]=2;
                            ret[count].pstn[i]=1;
                           
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[count].obj[j]==1)
                                {
                                    ret[count].pstn[j]--;
                                }
                            }
                            
                            z=0; 
                            
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[count].obj[j]==2)
                                {
                                    ret[count].pstn[j]++;
                                }
                            }
                            
                            z=0;                         
                            count++;
                        }
                        
                        else if(obj[i]==2)
                        {
                            ret[count].obj[i]=0;
                            ret[count].pstn[i]=1;
                            
                            int z=0;
                            
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[count].obj[j]==2)
                                {
                                    ret[count].pstn[j]=z++;
                                }
                            }
                            
                            z=0;
                            
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[count].obj[j]==0)
                                {
                                    ret[count].pstn[j]=z++;
                                }
                            }
                            
                            z=0;
                            count++;
                           
                            ret[count].obj[i]=1;
                            ret[count].pstn[i]=1;
                          
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[count].obj[j]==2)
                                {
                                    ret[count].pstn[j]--;
                                }
                            }
                            
                            z=0;
                            
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[count].obj[j]==1)
                                {
                                    ret[count].pstn[j]++;
                                }
                            }
                            
                            z=0;                           
                            count++;
                        }
                    }    
                                                  
                }
		return ret;
	}
        
	
	public boolean isIllegalState(){
            
		if(obj[0]==obj[1] && pstn[0]>=pstn[1])
                    return true;
                if(obj[0]==obj[2] && pstn[0]>=pstn[2])
                    return true;
                if(obj[1]==obj[2] && pstn[1]>=pstn[2])
                    return true;
		
		return false;
	}
        
       
	
	@Override
	public String toString() {
		return "" + obj[0] + obj[1] + obj[2]+pstn[0]+pstn[1]+pstn[2];
	}
	
}
