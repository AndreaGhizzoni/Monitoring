package it.hackcaffebabe.monitoring.rm;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


class ResourceMonitorFrame extends Frame
{
	private static final long serialVersionUID = 1L;
	PanelInfo pnl = new PanelInfo();

	public ResourceMonitorFrame(){
		super( "Resource Monitor" );
		setSize( 300, 75 );
		setLocation( 25, 25 );
		setUndecorated( true );
		setResizable( false );
		addWindowListener( new DisposeWin( this ) );
		add( pnl );
		setVisible( true );
	}

	class PanelInfo extends Panel
	{
		private static final long serialVersionUID = 1L;
		private Font f = new Font( Font.MONOSPACED, Font.PLAIN, 12 );
		private char[] max = new char[0];
		private char[] tot = new char[0];
		private char[] free = new char[0];

		public synchronized void update(String max, String tot, String free){
			this.max = max.toCharArray();
			this.tot = tot.toCharArray();
			this.free = free.toCharArray();
			repaint();
		}

		@Override
		public void paint(Graphics g){
			super.paint( g );
			g.setFont( f );
			g.drawChars( this.max, 0, this.max.length, 0, 10 );
			g.drawChars( this.tot, 0, this.tot.length, 0, 25);
			g.drawChars( this.free, 0, this.free.length, 0, 40);
		}
	}

	class DisposeWin implements WindowListener
	{
		private Frame f;

		public DisposeWin(Frame frame){
			this.f = frame;
		}

		@Override
		public void windowClosing(WindowEvent e){
			f.dispose();
			System.gc();
		}
        @Override
        public void windowOpened(WindowEvent e){}
		@Override
		public void windowClosed(WindowEvent e){}
		@Override
		public void windowIconified(WindowEvent e){}
		@Override
		public void windowDeiconified(WindowEvent e){}
		@Override
		public void windowActivated(WindowEvent e){}
		@Override
		public void windowDeactivated(WindowEvent e){}
	}
}
