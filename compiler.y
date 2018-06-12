%{
#include<stdio.h>
#include<stdlib.h>
int yylex();
void yyerror( char *error);
%}



%token keyword func identifier string digit sc operator 

%%

start:keyword keyword identifier operator digit sc
{
	printf("accepted");	
	exit(1);
}

%%

int main(){
	

	yyparse();
	return 0;

}
void yyerror(char *error)
{
	printf("ERROR");
}


//INPUT
//private float f = 9 ;



//EXECUTION STEPS
// lex analyzer.l

//yacc -d compiler.y

//gcc y.tab.c lex.yy.c -ll -ly -lm


//./a.out

