%{
#include<stdio.h>
#include<stdlib.h>
int yylex();
void yyerror(const char *msg);
int flag=0;
%}



%token noun pronoun verb predicate conjunction fs

%%
sentence:simple
	| compound
	;

simple: subject verb predicate fs
{
	printf("Simple sentence");
	flag=1;
	exit(0);
}
;

compound: subject verb predicate conjunction subject verb predicate fs
{
	printf("Compound sentence");
	flag=2;
	exit(0);
}
;

subject:noun
	|pronoun
	;
	

%%


int main()
{
yyparse();
exit(0);
return (0);
}

void yyerror(const char *msg)
{
if(flag==0)
printf("Not Accepted!");

}

//EXECUTION STEPS

//lex sent.l

//yacc -d sent.y

//gcc y.tab.c lex.yy.c -ll -ly -lm

//./a.out





