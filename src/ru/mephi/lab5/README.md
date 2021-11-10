# Задание

1) При помощи паттерна Builder реализовать бота для выдачи зарплаты сотрудникам:
  
    class Employee с полями: givenName, surName, age, gender (enum MALE, FEMALE), role (enum STAFF, MANAGER, EXECUTIVE), dept, eMail, phone,	address, city, state (область), code (код области); 

    class Accountant без полей:    
&emsp;    public void paySalary(Employee employee);   
&emsp;    public void payPremium(Employee employee); 

    На основе написанных классов продемонстрируйте работу со стримами:  
&emsp;    Выплата премии женщинам сотрудникам  
&emsp;    Выплата зарплаты сотрудникам определенного департамента  
&emsp;    Выплата премии сотрудникам старше 30, работающим в определенном департаменте   
&emsp;    Выплата зарплаты менеджерам  
&emsp;    Выплата премии стаффу  

2) Для своих реализованных классов Employee в лабораторной работе:  
  
    Создать и использовать Consumer Lambda Expression  
    Создать и использовать Function Lambda Expression  
    Создать и использовать Supplier Lambda Expression  
    Создать и использовать BiPredicate Lambda Expression  

3) Продемонстрировать работу следующих методов: map, peek, findFirst, max, min, average, sun, lazy операции.
