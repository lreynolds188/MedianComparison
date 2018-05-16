clc;
close all;
clear all;

M = csvread("bruteForceBasicOperationsCounterTest.csv");

[rows, columns] = size( M );

X = M( 2:rows, : ); 

n = X(:,1);
basicOp = X(:, 2);

% calcOp = ( 1 / (1 - 4/3) ) * ( (1 - 4/3 * n) / (1 - 3/4) - ( log(n) / log(3/4) - 1 ) );
calcOp = 0.5 * ( n.^2 + n );
% calcOp = n;

figure();
plot( n, basicOp);
hold on
plot( n, calcOp, 'r')
