/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi;


public class State {
	public int[] obj;
        public int[] pos;
	
	public State()
	{
		obj = new int[3];
                pos=new int[3];
		obj[0] = obj[1] = obj[2] = 0;
                pos[0]=0;
                pos[1]=1;
                pos[2]=2;
	}
	public State(int one, int two, int three,int posf,int poss,int post) {
		obj = new int[3];
                pos=new int[3];
		obj[0] = one;
		obj[1] = two;
		obj[2] = three;
                pos[0]=posf;
                pos[1]=poss;
                pos[2]=post;
                

	}
	
	public State[] generateNextState()
	{
		State ret[] = new State[6];
                int counter=0;
                for(int i=0;i<=5;i++)
                {
                     ret[i]=new State(obj[0],obj[1],obj[2],pos[0],pos[1],pos[2]);
                }
                for(int i=0;i<3;i++)
                {

                  //  ret[counter]=new State(obj[0],obj[1],obj[2],pos[0],pos[1],pos[2]);
                    if(pos[i]==0)
                    {
                        if(obj[i]==0)
                        {
                            ret[counter].obj[i]=1;
                            ret[counter].pos[i]=0;
                            int p=0;
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[counter].obj[j]==0)
                                {
                                    ret[counter].pos[j]--;
                                }
                            }
                            p=0; 
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[counter].obj[j]==1)
                                {
                                    ret[counter].pos[j]++;
                                }
                            }
                            p=0;
                            counter++;
                           // ret[++counter]=new State(obj[0],obj[1],obj[2],pos[0],pos[1],pos[2]);
                            ret[counter].obj[i]=2;
                            ret[counter].pos[i]=0;
                            
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[counter].obj[j]==0)
                                {
                                    ret[counter].pos[j]--;
                                }
                            }
                            p=0; 
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[counter].obj[j]==2)
                                {
                                    ret[counter].pos[j]++;
                                }
                            }
                            p=0;
                            
                            counter++;
                        }
                        else if(obj[i]==1)
                        {
                            ret[counter].obj[i]=0;
                            ret[counter].pos[i]=0;
                            int p=0;
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[counter].obj[j]==1)
                                {
                                    ret[counter].pos[j]--;
                                }
                            }
                            p=0; 
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[counter].obj[j]==0)
                                {
                                    ret[counter].pos[j]++;
                                }
                            }
                            p=0;
                            counter++;
                           // ret[++counter]=new State(obj[0],obj[1],obj[2],pos[0],pos[1],pos[2]);
                            ret[counter].obj[i]=2;
                            ret[counter].pos[i]=0;
                           
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[counter].obj[j]==1)
                                {
                                    ret[counter].pos[j]--;
                                }
                            }
                            p=0; 
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[counter].obj[j]==2)
                                {
                                    ret[counter].pos[j]++;
                                }
                            }
                            p=0;                         
                            counter++;
                        }
                        else if(obj[i]==2)
                        {
                            ret[counter].obj[i]=0;
                            ret[counter].pos[i]=0;
                            int p=0;
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[counter].obj[j]==2)
                                {
                                    ret[counter].pos[j]=p++;
                                }
                            }
                            p=0;
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[counter].obj[j]==0)
                                {
                                    ret[counter].pos[j]=p++;
                                }
                            }
                            p=0;
                            counter++;
                            //ret[++counter]=new State(obj[0],obj[1],obj[2],pos[0],pos[1],pos[2]);
                            ret[counter].obj[i]=1;
                            ret[counter].pos[i]=0;
                          
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[counter].obj[j]==2)
                                {
                                    ret[counter].pos[j]--;
                                }
                            }
                            p=0; 
                            for(int j=0;j<3;j++)
                            {
                                if(j!=i && ret[counter].obj[j]==1)
                                {
                                    ret[counter].pos[j]++;
                                }
                            }
                            p=0;                           
                            counter++;
                        }
                    }    
                                                  
                }
		return ret;
	}
	
	public boolean isIllegalState()
	{
		if(obj[0]==obj[1] && pos[0]>=pos[1])
                    return true;
                if(obj[0]==obj[2] && pos[0]>=pos[2])
                    return true;
                if(obj[1]==obj[2] && pos[1]>=pos[2])
                    return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		return "" + obj[0] + obj[1] + obj[2]+pos[0]+pos[1]+pos[2];
	}
	
}
