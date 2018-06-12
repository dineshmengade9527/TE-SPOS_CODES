%{
#include "y.tab.h"
#include<stdio.h>
%}

%%
i|he|she {return(pronoun);}
Ram|Raj {return(noun);}
and|for|either|or|neither|nor|but|also {return(conjunction);}
eats|plays|sings {return(verb);}
ice-cream|football|song {return(predicate);}
"." {return(fs);}
%%



//lex analyzer.l
//yacc compiler.y
//gcc y.tab.c lex.yy.c -ll -ly -lm
//./a.out

