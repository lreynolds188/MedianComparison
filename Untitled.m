clc;
close all;
clear all;

M = csvread("basicOperationsTest.csv");

n = M(:,1);
basicOp = M(:, 2);

calcOp = ;

figure();
plot( n, basicOp);
hold on
% plot( n, calcOp, 'r')