/*
 * Tejada, Jason
 * CS2013
 * 02/06/2020
 *
 * Desc: This program has the recursive function to make the HTree.
 */

package Hw01;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.geometry.Point2D;



public class HTreePane extends Pane {

	//Datafield
	private int order = 0;
	private double width;
	private double height;

	//Constructor
	public HTreePane(double width, double height) {
		this.width = width;
		this.height = height;	
	}

	public void setOrder(int order) {
		if(order < 0) {
			return;	
		}

		this.order = order;
		this.hTreeInit();	
	}

	public void hTreeInit() {
		Point2D center = new Point2D(this.width / 2, this.height / 2);
		double lineLength = width/2;
		this.getChildren().clear();
		
		//Calling method that makes the hTree(s) itself.
		this.makeTrees(this.order, lineLength, center);
	}

	private void makeTrees(int order, double lineLength, Point2D center) {

		//Halfing line each call
		double newLineLength = lineLength / 2;	

		//End points
		Point2D endPoint1 = new Point2D(center.getX() - newLineLength,
					center.getY() - newLineLength);

		Point2D endPoint2 = new Point2D(center.getX() + newLineLength,
					center.getY() - newLineLength);

		Point2D endPoint3 = new Point2D(center.getX() - newLineLength,
					center.getY() + newLineLength);

		Point2D endPoint4 = new Point2D(center.getX() + newLineLength,
					center.getY() + newLineLength);

		//Lines
		Line middleLine = new Line(center.getX() - newLineLength,
					center.getY(), center.getX() + newLineLength,
					center.getY());

		Line leftLine = new Line(endPoint1.getX(), endPoint1.getY(), 
					endPoint3.getX(), endPoint3.getY());

		Line rightLine = new Line(endPoint2.getX(), endPoint2.getY(),
					endPoint4.getX(), endPoint4.getY());
			
		if(order == 0) {
			this.getChildren().addAll(middleLine, leftLine, rightLine);
			return;

		}

		else {
			this.getChildren().addAll(middleLine, leftLine, rightLine);
			
			//Making the recursive call
			makeTrees(order - 1, newLineLength, endPoint1);
			makeTrees(order - 1, newLineLength, endPoint2);
			makeTrees(order - 1, newLineLength, endPoint3);
			makeTrees(order - 1, newLineLength, endPoint4);
		}	
	}
}
