clc;
close all;
clear all;

M = csvread("partitionExecutionTimeTest.csv");

n = M(:,1);
basicOp = M(:, 2);

% calcOp = ( 1 / (1 - 4/3) ) * ( (1 - 4/3 * n) / (1 - 3/4) - ( log(n) / log(3/4) - 1 ) );
calcOp = 0.5 * ( n ^2 + n );

figure();
plot( n, basicOp);
hold on
plot( n, calcOp, 'r')
