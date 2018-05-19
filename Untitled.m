clc;
close all;
clear all;

M = csvread("partitionExecutionTimeTest.csv");
X = csvread( "bruteForceExecutionTimeTest.csv");

n = M(:,1);
basicOp = M(:, 2);
basicOp2 = X(:, 2);

calcOp = 4 * n - log(n);
% calcOp = 0.5 * ( n.^2 + n );
% calcOp = n;

figure();
yyaxis left
plot( n, basicOp, "b-o");
xlabel( "Input data size" );
ylabel( "Experimental Time Execution (ns)" )
title( "Time Execution experimental and Theoriatical results" + newline + "for Partition Median Algorithm" );
hold on
yyaxis right
ylabel("Expected Time Complexity")
plot( n, calcOp, 'r')
% ylabel( "Number of Brute Force Median Basic Operations Executed")
legend( "Experimental Results", "Theoretical Results" )
