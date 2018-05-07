package com.game2048.app.util;

import java.util.ArrayList;
import java.util.List;
import com.game2048.app.UI.Card;
import com.game2048.app.UI.GameView;
import com.game2048.app.activity.MainActivity;
import com.game2048.app.activity.MyApplication;
import com.game2048.app.model.record;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Point;
import android.view.MotionEvent;


public class Move{
	//public static int[][] cardNum = new int[4][4];
	record r = record.getRecord();
	int t;
	boolean isAdd;
	private Card[][] cardNab = GameView.cardNab;
	private float startX,startY,offX,offY;
	//preferences p;
	private List<Point> emptyPoint = new ArrayList<Point>();
	private final static Move m= new Move();
	
	private Move() {
		// TODO 自动生成的构造函数存根	
		//p=preferences.getPreferences();
	}
	public static Move getMove(){
		return m;
	}
	
	public void getAction(MotionEvent event){
		switch(event.getAction()){
			case MotionEvent.ACTION_DOWN:
				startX=event.getX();
				startY=event.getY();
				break;
			case MotionEvent.ACTION_UP:
				offX=event.getX()-startX;
				offY=event.getY()-startY;
				switchMove();
				break;
		}
	}
	private void addRadomNum(){
		emptyPoint.clear();
		for (int i = 0; i <4; i++) {
			for (int j = 0; j <4; j++) {
				if(cardNab[i][j].getNum()<=0){
					emptyPoint.add(new Point(i, j));
				}
			}
		}
		Point p = emptyPoint.remove((int)(Math.random()*emptyPoint.size()));
		cardNab[p.x][p.y].setNum(Math.random()>0.1?2:4);
		if(isEnd()){
			//对话框
			AlertDialog.Builder dialog = new AlertDialog.Builder(MyApplication.getContext());
			dialog.setTitle("Game 2048");
			dialog.setMessage("游戏结束！重新开始...");
			dialog.setCancelable(false);
			dialog.setPositiveButton("确定", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO 自动生成的方法存根
					reStart();
				}
			});
			dialog.show();
			//reStart();
		}
		
	}
	private void switchMove(){
		if(Math.abs(offX)>Math.abs(offY)){
			if(offX<-10){
				toLeft();
				if(isAdd){
					addRadomNum();
					r.setRecore(r.getRecore()+t);
					r.setStep(r.getStep()+1);
					if(r.getRecore()>r.getMax()){
						r.setMax(r.getRecore());
					}
				}
			}			
			else if(offX>10){
				toRight();
				if(isAdd){
					addRadomNum();
					r.setRecore(r.getRecore()+t);
					r.setStep(r.getStep()+1);
					if(r.getRecore()>r.getMax()){
						r.setMax(r.getRecore());
					}
				}
			}				
		}
		else{
			if(offY>10){
				toDown();
				if(isAdd){
					addRadomNum();
					r.setRecore(r.getRecore()+t);
					r.setStep(r.getStep()+1);
					if(r.getRecore()>r.getMax()){
						r.setMax(r.getRecore());
					}
				}
			}				
			else if(offY<-10){
				toUp();
				if(isAdd){
					addRadomNum();
					r.setRecore(r.getRecore()+t);
					r.setStep(r.getStep()+1);
					if(r.getRecore()>r.getMax()){
						r.setMax(r.getRecore());
					}
				}
				
			}			
		}
		MainActivity.update(r.getRecore(),r.getStep(),r.getMax());
	}
	private void toLeft(){
		t=0;
		isAdd=false;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				for(int j2=j+1;j2<4;j2++){
					if(cardNab[i][j2].getNum()>0){
						if(cardNab[i][j].getNum()<=0){
							cardNab[i][j].setNum(cardNab[i][j2].getNum());
							cardNab[i][j2].setNum(0);
							isAdd=true;
							j--;
						}
						else{
							if(cardNab[i][j].equals(cardNab[i][j2])){
								cardNab[i][j].setNum(cardNab[i][j].getNum()*2);
								t+=cardNab[i][j].getNum();
								cardNab[i][j2].setNum(0);
								isAdd=true;
								
							}
						}
						break;
					}
					
				}
			}
		}
	}
	private void toRight(){
		t=0;
		isAdd=false;
		for (int i = 0; i < 4; i++) {
			for (int j = 3; j >=0; j--) {
				for (int j2 = j-1; j2 >=0; j2--) {
					if(cardNab[i][j2].getNum()>0){
						if(cardNab[i][j].getNum()<=0){
							cardNab[i][j].setNum(cardNab[i][j2].getNum());
							cardNab[i][j2].setNum(0);
							isAdd=true;
							j++;
						}
						else{
							if(cardNab[i][j].equals(cardNab[i][j2])){
								cardNab[i][j].setNum(cardNab[i][j].getNum()*2);
								t+=cardNab[i][j].getNum();
								cardNab[i][j2].setNum(0);
								isAdd=true;
							}
						}
						break;
					}
										
				}
			}
		}
	}
	private void toUp(){
		t=0;
		isAdd=false;
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i <4; i++) {
				for (int j2 = i+1; j2 <4; j2++) {
					if(cardNab[j2][j].getNum()>0){
						if(cardNab[i][j].getNum()<=0){
							cardNab[i][j].setNum(cardNab[j2][j].getNum());
							cardNab[j2][j].setNum(0);
							isAdd=true;
							i--;
						}
						else{
							if(cardNab[i][j].equals(cardNab[j2][j])){
								cardNab[i][j].setNum(cardNab[i][j].getNum()*2);
								t+=cardNab[i][j].getNum();
								cardNab[j2][j].setNum(0);
								isAdd=true;
							}
						}
						break;
					}
										
				}
			}
		}
	}
	private void toDown(){
		t=0;
		isAdd=false;
		for (int j = 0; j <4; j++) {
			for (int i = 3; i>=0; i--) {
				for (int j2 = i-1; j2>=0; j2--) {
					if(cardNab[j2][j].getNum()>0){
						if( cardNab[i][j].getNum()<=0){
							cardNab[i][j].setNum(cardNab[j2][j].getNum());
							cardNab[j2][j].setNum(0);
							isAdd=true;
							i++;
						}
						else{
							if(cardNab[i][j].equals(cardNab[j2][j])){
								cardNab[i][j].setNum(cardNab[i][j].getNum()*2);
								t+=cardNab[i][j].getNum();
								cardNab[j2][j].setNum(0);
								isAdd=true;
							}
						}
						break;
					}
					
				}
			}
		}
	}
	
	private boolean isEnd(){
		for(int i=0;i<4;i++){
			for(int j=0;j<3;j++){
				if(cardNab[i][j].equals(cardNab[i][j+1]))
					return false;
			}
		}
		for(int j=0;j<4;j++){
			for(int i=0;i<3;i++){
				if(cardNab[i][j].equals(cardNab[i+1][j]))
					return false;
			}
		}
		return true;
	}
	public void start(){
		addRadomNum();
		addRadomNum();
	}
	private void reStart(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++)
				cardNab[i][j].setNum(0);
		}
		if(r.getRecore()>r.getMax())
			r.setMax(r.getRecore());		
		start();
	}
	

}
