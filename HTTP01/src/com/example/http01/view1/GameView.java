package com.example.http01.view1;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.impl.client.TunnelRefusedException;

import com.example.http01.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class GameView extends View {

	private int mPanelwidth;
	private float lineHeight;
	private int MaxLine = 16;
	private int WinNum = 5;
	private float rate = 5.0f / 6;
	private Paint paint = new Paint();
	private Bitmap whietP;
	private Bitmap blackP;
	private List<Point> whietList = new ArrayList<Point>();
	private List<Point> blackList = new ArrayList<Point>();
	private Boolean first = true;
	private Boolean isOver = false;
	private int winner = 0; // 0,白方胜；1，黑方胜

	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO 自动生成的构造函数存根
		init();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO 自动生成的构造函数存根
		init();
	}

	public GameView(Context context) {
		super(context);

		init();
	}

	private void init() {

		paint.setColor(0xff000000);
		paint.setStrokeWidth(3.0f);
		paint.setAntiAlias(true);
		paint.setDither(true);
		paint.setStyle(Paint.Style.STROKE);
		whietP = BitmapFactory.decodeResource(getResources(), R.drawable.whiet);
		blackP = BitmapFactory.decodeResource(getResources(), R.drawable.black);

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		int heightSize = MeasureSpec.getSize(heightMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int width = Math.min(widthSize, heightSize);
		if (widthMode == MeasureSpec.UNSPECIFIED) {
			width = heightSize;
		} else if (heightMode == MeasureSpec.UNSPECIFIED) {
			width = widthSize;
		}
		setMeasuredDimension(width, width);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO 自动生成的方法存根
		super.onSizeChanged(w, h, oldw, oldh);
		mPanelwidth = w;
		lineHeight = h * 1.0f / MaxLine;
		whietP = Bitmap.createScaledBitmap(whietP, (int) (lineHeight * rate), (int) (lineHeight * rate), false);
		blackP = Bitmap.createScaledBitmap(blackP, (int) (lineHeight * rate), (int) (lineHeight * rate), false);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO 自动生成的方法存根
		super.onDraw(canvas);
		drawBorder(canvas);
		drawPiece(canvas);
	}

	private void drawBorder(Canvas canvas) {

		for (int i = 0; i < MaxLine; i++) {
			int startXY = (int) (lineHeight / 2);
			int endXY = mPanelwidth - startXY;
			int XY = (int) ((0.5 + i) * lineHeight);
			canvas.drawLine(startXY, XY, endXY, XY, paint);
			canvas.drawLine(XY, startXY, XY, endXY, paint);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		if (isOver) {
			return false;
		}

		int action = event.getAction();
		if (action == MotionEvent.ACTION_UP) {
			float x = event.getX();
			float y = event.getY();
			Point p = getPiecePoint(x, y);

			if (whietList.contains(p) || blackList.contains(p)) {
				return false;
			}
			if (first) {
				whietList.add(p);
			} else {
				blackList.add(p);
			}
			invalidate();
			checkOver();
			if (!isOver)
				first = !first;
			else {
				AlertDialog.Builder builder = new Builder(getContext());
				builder.setTitle("提示");
				builder.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
				builder.setMessage("游戏结束！");
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO 自动生成的方法存根

					}
				});
				builder.show();
			}

		}

		return true;
	}

	private void checkOver() {

		if (first)
			check(whietList);
		else
			check(blackList);
	}

	private void check(List<Point> list) {
		int x, y;
		for (Point point : list) {
			x = point.x;
			y = point.y;
			int i;
			for (i = 0; i < WinNum; i++) {
				if (!list.contains(new Point(x + i, y)))
					break;
			}
			if (i != WinNum) {
				for (i = 0; i < WinNum; i++) {
					if (!list.contains(new Point(x, y + i)))
						break;
				}
				if (i != WinNum) {
					for (i = 0; i < WinNum; i++) {
						if (!list.contains(new Point(x + i, y + i)))
							break;
					}
				}
			}
			if (i == WinNum) {
				isOver = true;
				break;
			}

		}
	}

	private void drawPiece(Canvas canvas) {
		for (int i = 0; i < whietList.size(); i++) {
			Point p = whietList.get(i);
			canvas.drawBitmap(whietP, (p.x + (1 - rate) / 2) * lineHeight, (p.y + (1 - rate) / 2) * lineHeight, null);
		}
		for (int i = 0; i < blackList.size(); i++) {
			Point p = blackList.get(i);
			canvas.drawBitmap(blackP, (p.x + (1 - rate) / 2) * lineHeight, (p.y + (1 - rate) / 2) * lineHeight, null);
		}
	}

	private Point getPiecePoint(float x, float y) {
		// TODO 自动生成的方法存根

		return new Point((int) (x / lineHeight), (int) (y / lineHeight));
	}

}
