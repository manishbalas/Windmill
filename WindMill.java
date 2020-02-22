import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//prg--45

/*<applet code="WindMill" width=600 height=600>
</applet*/

public class WindMill extends Applet implements Runnable
{
	public int Spin;
	Thread t;	
	Label l1;
	TextField t1;
	Button b1;
	Scanner sc;

	// public WindMill(int test)
	// {
	// 	Spin=test;
	// }

	public void init()
	{
		
		l1=new Label("Enter Number To Spin");
		t1=new TextField(2);
	    b1=new Button("Spin It");	
	    setLayout(null);
        l1.setBounds(30,50,100,20);
        t1.setBounds(150,50,100,20);
        b1.setBounds(100,150,80,20);
        add(l1);
        add(t1);
        add(b1);
        b1.addActionListener(new Wind());
		t=new Thread(this);
		t.start();
	    sc=new Scanner(System.in);  
   
	}	

	
	public void run()
	{


		try
		{
			System.out.print("Enter no to Spin:");
            Spin=sc.nextInt();
			int b=Spin;
			
			while(Spin!=b)
			{	
				repaint();			
				Thread.sleep(100);
				Spin+=1;

			}
		}
			catch(Exception e)
			{
				System.out.println("Exception found");

			}
		}
			public void paint(Graphics g)
			{
				

			    g.drawString(" "+Spin,50,10);
			   // g.drawString(" "+a,100,10);
			    
				g.fillRoundRect(240,190,10,150,40,20);//stand
				g.fillOval(220,333,50,10);//Roundstand
				g.setColor(Color.red);

				if(Spin%2==0)
				{
					
					g.fillArc(200,150,90,90,45,45);//mill2					
					g.fillArc(200,150,90,90,135,45);//mill4					
					g.fillArc(200,150,90,90,225,45);//mill6					
					g.fillArc(200,150,90,90,315,45);//mill8		
					
				}
				else 
				{					

				    g.fillArc(200,150,90,90,0,45);//mill1
				    g.fillArc(200,150,90,90,90,45);//mill3
				    g.fillArc(200,150,90,90,180,45);//mill5
				    g.fillArc(200,150,90,90,270,45);//mill7
				   
				 
				}				
			
			}
		

		public class Wind implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {  
                 int a;

                 a=Integer.parseInt(t1.getText());
                 WindMill w1=new WindMill();
                 Spin=a;

                 System.out.println(a);
                 //Spin=a;                  
            }

   }
}