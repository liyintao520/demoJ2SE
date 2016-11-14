package com.lyt.enums;

public class Test {
	
	@org.junit.Test
	public void colorEnum(){
		//枚举是一种类型，用于定义变量，以限制变量的赋值；赋值时通过“枚举名.值” 取得枚举重的值
		ColorEnum colorEnum = ColorEnum.blue;
		switch (colorEnum) {
			case red:
				System.out.println("颜色是红色 red");
				break;
			case green:
                System.out.println("color is green");
                break;
            case yellow:
                System.out.println("color is yellow");
                break;
            case blue:
                System.out.println("color is blue");
                break;
		}
		//遍历枚举
		System.out.println("遍历ColorEnum枚举中的值");
		for (ColorEnum color : ColorEnum.values()) {
			System.out.println("遍历枚举color = " + color);
		}
		//获取枚举的个数
		System.out.println("ColorEnum枚举中的值有：" + ColorEnum.values().length + "个");
		
		//获取枚举的索引位置，默认从0开始	 ordinal()返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）。
        System.out.println("索引位置："+ColorEnum.red.ordinal());//0
        System.out.println("索引位置："+ColorEnum.green.ordinal());//1
        System.out.println("索引位置："+ColorEnum.yellow.ordinal());//2
        System.out.println("索引位置："+ColorEnum.blue.ordinal());//3
        //枚举默认实现了java.lang.Comparable接口
        System.out.println("类型比较："+ColorEnum.red.compareTo(ColorEnum.green));//-1
	}
	@org.junit.Test
    public void seasonEnum(){
		//枚举像普通的类一样可以添加属性和方法，可以为它添加静态和非静态的属性或方法
        System.out.println("季节为：" + SeasonEnum.getSeason());
    }
	@org.junit.Test
    public void genderEnum(){
        for(GenderEnum gender : GenderEnum.values()){
            System.out.println("迭代得到的code值："+gender.code);
            System.out.println("迭代得到的name值："+gender.name());
        }
        
        if(GenderEnum.MAN.getCode().equals("0")){
            System.out.println("true");
            System.out.println(GenderEnum.getByCode("0").getSex());
        }
        
        System.out.println(GenderEnum.nameOf("man"));
    }
	@org.junit.Test
    public void orderStateEnum(){
		//实现带有抽象方法的枚举
		System.out.println("实现带有抽象方法的枚举:");
        for(OrderStateEnum order : OrderStateEnum.values()){
            System.out.print(order);
            System.out.println(" --------- " + order.getName());
        }
    }
}
