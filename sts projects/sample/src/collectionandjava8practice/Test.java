package collectionandjava8practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		List<Aadhar> list = Arrays.asList(
				new Aadhar(1234123, "ram", new Address("234", "1st street", "chennai", "tamilnadu")),
				new Aadhar(123456, "kumar", new Address("2344", "12st street", "kanniyakumari", "tamilnadu")),
				new Aadhar(123123, "srinath", new Address("2343", "2st street", "chennai", "tamilnadu")));

		Map<Integer, Aadhar> map = new HashMap<>();
		for (Aadhar aadhar : list) {
			map.put(aadhar.getAadharno(), aadhar);
		}

		System.out.println("Map entryset: " + map.entrySet());

		System.out.println("List of Aadhar: " + list);

		List<Aadhar> fs = list.stream().filter(a -> a.getAddress().getDistrict().equals("chennai"))
				.collect(Collectors.toList());

		System.out.println("List of Aadhar details based on the district chennai: " + fs);

		List<Product> pro = Arrays.asList(new Product(1, "Samsung", 42000.98, true),
				new Product(2, "Apple", 100000.42, false), new Product(3, "Redmi", 10000.67, true),
				new Product(4, "Samsung", 12000.58, true), new Product(5, "Samsung", 27040.39, false),
				new Product(6, "Apple", 180000.99, true));

		Map<Integer, Product> promap = new HashMap<>();

		for (Product product : pro) {
			promap.put(product.getProdid(), product);
		}

		System.out.println("Product in entryset Map: " + promap.entrySet());
		// get the product of highest price
		Product product = pro.stream().max((o1, o2) -> (int) (o1.getPrice() - o2.getPrice())).get();
		System.out.println(product);

		// display the product details based on the descending order of name
		List<Product> list1 = pro.stream().sorted((o1, o2) -> o2.getName().compareTo(o1.getName()))
				.collect(Collectors.toList());
		System.out.println(list1);

		// display the product details based on the stock available
		list1 = pro.stream().filter(p -> p.isInStock()).collect(Collectors.toList());
		System.out.println(list1);

		// count the product not in stock
		long count = pro.stream().filter(t -> !t.isInStock()).count();
		System.out.println(count);

		// get the data based on the product sumsung and price above 20000
		list1 = pro.stream().filter(p -> p.getName().equalsIgnoreCase("samsung")).filter(p -> p.getPrice() > 20000)
				.collect(Collectors.toList());
		System.out.println(list1);

		list1 = pro.stream().filter(p -> p.getName().equalsIgnoreCase("apple")).map(p -> {
			p.setPrice(p.getPrice() * 0.9);
			return p;
		}).collect(Collectors.toList());
		System.out.println(list1);

		Map<Integer, Product> getmap = promap.entrySet().stream().filter(m -> m.getValue().getPrice() > 20000)
				.collect(Collectors.toMap(m -> m.getKey(), m -> m.getValue()));

		System.out.println("Diplay the value filter by price: " + getmap);

		Set<Double> price = promap.entrySet().stream().filter(m -> m.getValue().getName().equalsIgnoreCase("apple"))
				.map(m -> m.getValue().getPrice()).collect(Collectors.toSet());
		
		System.out.println("Display the product price based on the product name Apple:\n"+price);
		
		Map<Integer, Aadhar> aadharmap = map.entrySet().stream()
				.filter(m -> m.getValue().getAddress().getDistrict().equalsIgnoreCase("chennai"))
				.collect(Collectors.toMap(m-> m.getKey(), m-> m.getValue()));
		
		System.out.println("Filter the Aadhar based on the district in chennai:\n"+aadharmap);
		
		pro.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(System.out::println);
		
		Map<String, List<Product>> das = pro.stream().collect(Collectors.groupingBy(Product::getName));
		
		for(String str : das.keySet()) System.out.println(str+"=     "+das.get(str));
	}

}
