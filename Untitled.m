clc;
close all;
clear all;

M = csvread("partitionExecutionTimeTest.csv");
X = csvread( "bruteForceExecutionTimeTest.csv");

n = M(:,1);
basicOp = M(:, 2);
basicOp2 = X(:, 2);

calcOp = ( 1 / (1 - 2) ) * ( (1 - 2 * n) / (1 - 1/2) - ( log(n) / log(1/2) - 1 ) );
% calcOp = 0.5 * ( n.^2 + n );
% calcOp = n;

figure();
yyaxis left
plot( n, basicOp, "b-o");
xlabel( "Input data size" );
ylabel( "Partition Execution Time (ns)" )
title( "Paritioning vs Brute Force Median" + newline + "Execution Time Results" );
hold on
yyaxis right
plot( n, basicOp2, 'r-o')
ylabel( "Brute Force Time Execution (n)")
% ylabel( "Number of Brute Force Median Basic Operations Executed")
legend( "Paritioning Median Algorithm", "Brute Force Median Algorithm" )
