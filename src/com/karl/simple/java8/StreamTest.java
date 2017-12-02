package com.karl.simple.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamTest {

	final Trader raoul = new Trader("Raoul", "Cambridge");
	final Trader mario = new Trader("Mario", "Milan");
	final Trader alan = new Trader("Alan", "Cambridge");
	final Trader brian = new Trader("Brian", "Cambridge");

	final List<Transaction> transactions = Arrays
			.asList(new Transaction(brian, 2011, 300), new Transaction(raoul,
					2012, 1000), new Transaction(raoul, 2012, 400),
					new Transaction(mario, 2012, 710), new Transaction(mario,
							2012, 700), new Transaction(alan, 2012, 950));

	@Test
	public void test0() {
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);

		List<int[]> pairs = numbers1.stream()
				.flatMap(i -> numbers2.stream().map(j -> new int[] { i, j }))
				.map(d -> (int[]) d).collect(Collectors.toList());
		pairs.stream().forEach(d -> {
			System.out.println("(" + d[0] + "," + d[1] + ")");
		});
	}

	@Test
	public void test1() {
		List<Transaction> targetList = transactions.stream().filter(x -> {
			return x.getYear() == 2012;
		}).sorted(Comparator.comparing(Transaction::getValue).reversed())
				.collect(Collectors.toList());

		targetList.forEach(x -> {
			System.out.println(x.toString());
		});
	}

	@Test
	public void test2() {
		Map<Trader, Set<Integer>> targetList = transactions.stream().collect(
				Collectors.groupingBy(
						Transaction::getTrader,
						Collectors.mapping(Transaction::getYear,
								Collectors.toSet())));
	}

	@Test
	public void test3() {
		List<Trader> targetList = transactions.stream()
				.map(Transaction::getTrader)
				.filter(x -> "Cambridge".equals(x.getCity())).distinct()
				.sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());

		targetList.forEach(x -> {
			System.out.println(x.toString());
		});
	}

	@Test
	public void test4() {
		List<String> targetList = transactions.stream()
				.map(d -> d.getTrader().getName().split(""))
				.flatMap(Arrays::stream).distinct().sorted()
				.collect(Collectors.toList());

		targetList.forEach(x -> {
			System.out.println(x.toString());
		});
	}

	@Test
	public void test5() {
		Optional<Transaction> op = transactions.stream()
				.filter(d -> "Mlan".equals(d.getTrader().getCity())).findAny();

		transactions.stream().anyMatch(
				d -> "Mlan".equals(d.getTrader().getCity()));

		op.ifPresent(d -> {
			System.out.println(d.toString());
		});
	}

	@Test
	public void test6() {
		int result = transactions.stream()
				.filter(x -> "Cambridge".equals(x.getTrader().getCity()))
				.map(Transaction::getValue).reduce(0, Integer::sum);

		System.out.println("Cabridge sum=" + result);
	}

	@Test
	public void test7() {
		int result = transactions.stream().map(Transaction::getValue)
				.reduce(0, Integer::max);

		System.out.println("Cabridge max=" + result);
	}

	@Test
	public void test8() {
		Optional<Transaction> op = transactions.stream()
				.sorted((x, y) -> Integer.compare(y.getValue(), x.getValue()))
				.findFirst();

		Optional<Transaction> op1 = transactions.stream().min(
				(x, y) -> Integer.compare(y.getValue(), x.getValue()));

		Optional<Transaction> op2 = transactions.stream().reduce(
				(x, y) -> x.getValue() < y.getValue() ? x : y);

		op.ifPresent(d -> {
			System.out.println(d.toString());
		});
	}

	/**
	 * 勾股定律
	 */
	@Test
	public void test9() {
		Stream<int[]> pythagoreanTriples = IntStream
				.rangeClosed(1, 100)
				.boxed()
				.flatMap(
						a -> IntStream
								.rangeClosed(a, 100)
								.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
								.mapToObj(
										b -> new int[] { a, b,
												(int) Math.sqrt(a * a + b * b) }));
		pythagoreanTriples.limit(5).forEach(
				t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
	}

	/**
	 * 勾股定律
	 */
	@Test
	public void test10() {
		Stream<double[]> pythagoreanTriples2 = IntStream
				.rangeClosed(1, 100)
				.boxed()
				.flatMap(
						a -> IntStream
								.rangeClosed(a, 100)
								.mapToObj(
										b -> new double[] { a, b,
												Math.sqrt(a * a + b * b) })
								.filter(t -> t[2] % 1 == 0));

		pythagoreanTriples2.limit(5).forEach(
				t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
	}
}
