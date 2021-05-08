 #include <stdio.h>

 int main()
 {
     int a,i,sum=0;

     for (i=1;i<=10;i++)
     {
         scanf("%d",&a);
         sum+=a;
     }
     printf("%d",sum/10);
     return 0;
 }
