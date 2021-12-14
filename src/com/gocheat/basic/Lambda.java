package com.gocheat.basic;

import java.util.function.Function;

public class Lambda {

	public static Function<Integer, String> ss() {
		return (a) -> String.valueOf(a)+"테스트";
	}

	public static void main(String[] args) {
		System.out.println(ss().apply(12));

		Math plusLambda = (first, second) -> first + second;
		System.out.println(plusLambda.Calc(4, 2));

		Math subLambda = (first, second) -> first - second;
		System.out.println(subLambda.Calc(4, 2));
	}
}

@FunctionalInterface
interface Math {
	int Calc(int first, int second);
}
