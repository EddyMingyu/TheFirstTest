package com.atguigu.CRM.List;
import com.atguigu.CRM.domain.Customer;
/**
 * 建立一个业务类
 * @author Eddy Cui
 *
 */
public class CustomerList {
	/*按照设计要求编写CustomerList类，并编译
在CustomerList类中临时添加一个main方法中，作为单元测试方法。
*/
	public static void main(String[] args) {
		/*
		 * 在方法中创建CustomerList对象（最多存放5个客户对象），然后分别用模拟数据调用以下各个方法，以测试各方法是否编写正确：
addCustomer
		 */
		/*CustomerList customers = new CustomerList(5);
		//Customer [] customers = new Customer [3];
		Customer newCust = new Customer("赵梦",'女',21,"13854632256","aas@masd.com");
		Customer newCust1 = new Customer("赵梦1",'女',22,"13854632252","abs@masd.com");
		Customer newCust2 = new Customer("赵梦2",'女',23,"13854632253","acs@masd.com");
		System.out.println(newCust.getDetails());
		customers.addCustomer(newCust);
		System.out.println(customers.addCustomer(newCust));
		System.out.println(customers.addCustomer(newCust1));
		System.out.println(customers.addCustomer(newCust2));
//replaceCustomer boolean
		System.out.println(customers.replaceCustomer(3, newCust));
//deleteCustomer boolean
		//System.out.println(new1.deleteCustomer(3));
//getAllCustomers Customer []
		System.out.println(customers.getAllCustomers());
//getCustomer Customer
		System.out.println(customers.getCustomer(2).getDetails());*/
	}
	/**
	 * CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象
本类封装以下信息：
Customer[] customers：用来保存客户对象的数组
int total = 0                 ：记录已保存客户对象的数量
该类至少提供以下方法：
public CustomerList(int totalCustomer) 
public boolean addCustomer(Customer customer) 
public boolean replaceCustomer(int index, Customer cust)
public boolean deleteCustomer(int index)
public Customer[] getAllCustomers() 
public Customer getCustomer(int index)
	 */
	private Customer [] customers;
	//private int totalCustomer;
	private int total=0 ;
	public CustomerList(int totalCustomer){
		customers = new Customer [totalCustomer]; 
	}
	CustomerList(){
		
	}
	public Customer[] getCustomers() {
		return customers;
	}
	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
   /**
    * 用途：将参数customer添加组中最后一个客户对象记录之后
               参数：customer指定要添加的客户对象 
               返回：添加成功返回true；false表示数组已满，无法添加
    */
   public boolean addCustomer(Customer customer) {
	   if (total==customers.length){
		   System.out.println("数组已满，无法添加！");
		   return false;
		   }else{
	   customers[total]=customer;
	   customers[total].setId(++total);
	   //new Customer();
	   /*customers[total].setName(customer.getName());
	   customers[total].setGender(customer.getGender());
	   customers[total].setAge(customer.getAge());
	   customers[total].setPhone(customer.getPhone());
	   customers[total].setEmail(customer.getEmail());*/
	   //total++;
		  return true;
		  }
	   }
   public boolean replaceCustomer(int index, Customer cust){
	   /**
                         用途：用参数customer替换数组中由index指定的对象
                         参数：customer指定替换的新客户对象 
		           index指定所替换对象在数组中的位置
                         返回：替换成功返回true；false表示索引无效，无法替换

	    */
	   if(index<0||index>total ){
		   return false;
	   }else{
		   customers[index] = cust;
		   customers[index].setId(index+1);
	   /*customers [index].setName(cust.getName());
	   customers [index].setGender(cust.getGender());
	   customers [index].setAge(cust.getAge());
	   customers [index].setPhone(cust.getPhone());
	   customers [index].setEmail(cust.getEmail());*/
	   return true;
	   }
	   /*if(customers [index].getName()==cust.getName()
			   &&customers [index].getGender()==cust.getGender()
			   &&customers [index].getAge()==cust.getAge()
			   &&customers [index].getPhone()==cust.getPhone()
			   &&customers [index].getEmail()==cust.getEmail())
	   return true;
	   else
		   return false;*/
   }
   public boolean deleteCustomer(int index){
	   if(index<0||index>total){
		   return false;
	   }else{
	   /*for(int i =0;i<=total-index;i++){
		   customers[index]=customers[index+1];*/
		   for (int i = index;i<total-1;i++){
			   customers[index]=customers[index+1];
			   customers[index].setId(index+1);
	   }
		   customers[total-1]=null;
		   total--;
	   return true;
	   }
   }
   public Customer[] getAllCustomers() {
        Customer [] fullCust = new Customer[total];
        for(int i = 0;i<fullCust.length;i++){
        	fullCust[i]=customers[i];
        }
	   return fullCust;
   }
   /**
    * 返回输入该编号的客户信息
    * @param index
    * @return Customer类型
    */
   public Customer getCustomer(int index){
	  // Customer customer = new Customer();
           if (index<0||index>=total)
        	   return null;
	       return customers[index];
   }
   /**
    * 返回是否存在所查找的客户编号
    * @param index
    * @return int
    */
   public int getIsCustomer(int index){
	   if (index>=0&&index<=total)
		   return index;
	   return -1;
   }
   /**
    * 返回客户列表
    */
   public void getDetails(){
   for(int i = 0;i<total;i++){
		System.out.println(getAllCustomers()[i].getDetails());
	}
   }
}
