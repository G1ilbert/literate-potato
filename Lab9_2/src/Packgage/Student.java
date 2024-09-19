package Packgage;

public class Student {
	private String name;
	private String grade;
	public Student(String name, String code) {
		super();
		this.name = name;
		this.grade = code;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCode(String code) {
		this.grade = code;
	}
	public String getName() {
		return name;
	}
	public String getGrade() {
		return grade;
	}
	public void show()
	{
		double grade=0;
		int count =0;
		if(this.name.matches(".*\\s.*")) {
			System.out.println("SpaceException :(space is not allowed in name) can not display.");
			return;
		}
		else if(!name.equals(name.replaceAll("[0-9]", ""))) {
			System.out.println("DigitException :(digit is not allowed in name) can not display.");
			return;
		}
		/*if(!name.equals(name.replaceAll("[0-9]", ""))) {
			System.out.println("DigitException :(digit is not allowed in name) can not display.");
			return;
		}
		else if(this.grade.indexOf(" ") != -1) {
			System.out.println("SpaceException :(space is not allowed in name) can not display.");
			return;
		}*/
		else
		{
			for(int i=0; i < this.grade.length();i++)
			{
				char ch = this.grade.charAt(i);
				switch(ch)
				{
				case 'A':
					grade+=4;
					count++;
					break;
				case 'B':
					grade+=3;
					count++;
					break;
				case 'C':
					grade+=2;
					count++;
					break;
				case 'D':
					grade+=1;
					count++;
					break;
				default:
					if(count == 0) {
						System.out.println("GradeException :(grade must be A B C D E F) can not display. ");
						return;
					}
					else {
						System.out.println("IncompleteException :(grade I is incomplete) can not display.");
						return;
					}
				}
				
				
			}
			System.out.println(name + " registered "+count+" subjects and got GPA "+ grade/count);
		}
			
	}
}
