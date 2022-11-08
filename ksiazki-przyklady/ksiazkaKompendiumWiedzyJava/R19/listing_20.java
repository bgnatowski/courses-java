// Uwaga: to fragment kodu, tego przykładu nie da się skompilować w takiej postaci
// Wykorzystanie iteratora do wyświetlenia zawartości
Iterator<Integer> vItr = v.iterator();

System.out.println("\nElementy wektora:");
while(vItr.hasNext())
  System.out.print(vItr.next() + " ");
System.out.println();
