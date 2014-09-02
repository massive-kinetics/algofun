package com.algofun.different;

import java.util.*;


public class EmployeeCollection {

    public static void main(String[] args){
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("Mary", null));
        list.add(new Employee("John", "Mary"));
        list.add(new Employee("Peter", "John"));
        list.add(new Employee("David", "Mary"));
        list.add(new Employee("Jane", "John"));
        list.add(new Employee("Scott", "Jane"));
        list.add(new Employee("Minh", "Scott"));
        list.add(new Employee("Sery", "Minh"));
        list.add(new Employee("Lubna", "Sery"));
        list.add(new Employee("Slava", "Lubna"));
        list.add(new Employee("Slava", "Lubna"));

        list.add(new Employee("Vanya", "Slava"));
        list.add(new Employee("Igor", "Vanya"));
        list.add(new Employee("Oleg", "Igor"));
        list.add(new Employee("Mudila", "Oleg"));
        list.add(new Employee("Mudila2", "Oleg"));



        EmployeeCollection collection = new EmployeeCollection();
        Set<String> set = collection.findSubOrdinates("Igor", list);

        System.out.println(Arrays.toString(set.toArray()));
    }

    Map<String, String> empMap;
    Map<String, Set<String>> empToBosses;

    int N = 0;

    public Set<String> findSubOrdinates(String name, Collection<Employee> list){
        fillMaps(list);
        Set<String> ordinates = new HashSet<String>();
        ordinates.add(name);

        for(String currEmp:empToBosses.keySet()){
            Set<String> bosses = empToBosses.get(currEmp);
            if(bosses.contains(name)) ordinates.add(currEmp);
        }

        System.out.println("N = " + N);
        return ordinates;
    }

    public void fillMaps(Collection<Employee> employees){
        empMap = new HashMap<String, String>();
        for(Employee e : employees){
            empMap.put(e.name, e.reportTo);
            N++;
        }

        empToBosses = new HashMap<String, Set<String>>();
        for(Employee e : employees){
            empToBosses.put(e.name, getBossSet(e.name));
            N++;
        }

    }

    public Set<String> getBossSet(String name){
        N++;
        Set<String> result = new HashSet<String>();
        String boss = empMap.get(name);
        if(boss != null){
            result.add(boss);
            result.addAll(getBossSet(boss));
        }
        return result;
    }

    static class Employee {
        public Employee(String n, String r){
            name = n;
            reportTo = r;
        }
        public String name;
        public String reportTo;
    }
}
