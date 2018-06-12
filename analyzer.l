%{
#include<stdio.h>
#include "y.tab.h"
%}

%%
int|float|double|char|string|public|private|protected|static|class|return|String {return(keyword);}
main|System.out.println {return(func);}
[A-Za-z_$]([A-Za-z]|[0-9])* {return(identifier);}
";" {return(sc);}
[0-9]+ {return(digit);}
[=] {return(operator);}

%%


