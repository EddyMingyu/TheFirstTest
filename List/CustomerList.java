package com.atguigu.CRM.List;
import com.atguigu.CRM.domain.Customer;
/**
 * ����һ��ҵ����
 * @author Eddy Cui
 *
 */
public class CustomerList {
	/*�������Ҫ���дCustomerList�࣬������
��CustomerList������ʱ���һ��main�����У���Ϊ��Ԫ���Է�����
*/
	public static void main(String[] args) {
		/*
		 * �ڷ����д���CustomerList���������5���ͻ����󣩣�Ȼ��ֱ���ģ�����ݵ������¸����������Բ��Ը������Ƿ��д��ȷ��
addCustomer
		 */
		/*CustomerList customers = new CustomerList(5);
		//Customer [] customers = new Customer [3];
		Customer newCust = new Customer("����",'Ů',21,"13854632256","aas@masd.com");
		Customer newCust1 = new Customer("����1",'Ů',22,"13854632252","abs@masd.com");
		Customer newCust2 = new Customer("����2",'Ů',23,"13854632253","acs@masd.com");
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
	 * CustomerListΪCustomer����Ĺ���ģ�飬�ڲ����������һ��Customer����
�����װ������Ϣ��
Customer[] customers����������ͻ����������
int total = 0                 ����¼�ѱ���ͻ����������
���������ṩ���·�����
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
    * ��;��������customer����������һ���ͻ������¼֮��
               ������customerָ��Ҫ��ӵĿͻ����� 
               ���أ���ӳɹ�����true��false��ʾ�����������޷����
    */
   public boolean addCustomer(Customer customer) {
	   if (total==customers.length){
		   System.out.println("�����������޷���ӣ�");
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
                         ��;���ò���customer�滻��������indexָ���Ķ���
                         ������customerָ���滻���¿ͻ����� 
		           indexָ�����滻�����������е�λ��
                         ���أ��滻�ɹ�����true��false��ʾ������Ч���޷��滻

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
    * ��������ñ�ŵĿͻ���Ϣ
    * @param index
    * @return Customer����
    */
   public Customer getCustomer(int index){
	  // Customer customer = new Customer();
           if (index<0||index>=total)
        	   return null;
	       return customers[index];
   }
   /**
    * �����Ƿ���������ҵĿͻ����
    * @param index
    * @return int
    */
   public int getIsCustomer(int index){
	   if (index>=0&&index<=total)
		   return index;
	   return -1;
   }
   /**
    * ���ؿͻ��б�
    */
   public void getDetails(){
   for(int i = 0;i<total;i++){
		System.out.println(getAllCustomers()[i].getDetails());
	}
   }
}
