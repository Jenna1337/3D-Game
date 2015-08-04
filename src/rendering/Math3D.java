package rendering;

class Main
{
}
public final class Math3D
{
	public static void main (String[] args)
	{
		Point3DFloat p1 = new Point3DFloat(1,0,0),
				p2 = new Point3DFloat(1,1,0),
				p3 = new Point3DFloat(1,1,1),
				p4 = new Point3DFloat(-1,-1,-1),
				p5 = new Point3DFloat(0,0,0);
		RenderPlane plane = new RenderPlane(p1, p2, p3);
		LineFloat line = new LineFloat(p4, p5);
		Point3DFloat intersect = Math3D.intersection(plane, line);
		System.out.println(intersect.toString().replace(", ","\n"));
	}
	public static Point3DFloat midpoint(Point3DFloat p1, Point3DFloat p2)
	{
		double mX=(p1.getX()+p2.getX())/2.0;
		double mY=(p1.getY()+p2.getY())/2.0;
		double mZ=(p1.getZ()+p2.getZ())/2.0;
		return new Point3DFloat((float)mX, (float)mY, (float)mZ);
	}
	public static Point3DFloat intersection(RenderPlane p, LineFloat l)
	{
		/**Plane point 1**/
		float x1=p.getP1().getX(), y1=p.getP1().getY(), z1=p.getP1().getZ();
		/**Plane point 2**/
		float x2=p.getP2().getX(), y2=p.getP2().getY(), z2=p.getP2().getZ();
		/**Plane point 3**/
		float x3=p.getP3().getX(), y3=p.getP3().getY(), z3=p.getP3().getZ();
		/**Line point 1**/
		float x4=l.getP1().getX(), y4=l.getP1().getY(), z4=l.getP1().getZ();
		/**Line point 2**/
		float x5=l.getP2().getX(), y5=l.getP2().getY(), z5=l.getP2().getZ();
		/**Intersect Point**/
		float x, y, z;
		/**Arrays**/
		float[] an=
				new float[]{
						1,1,1,1,
						x1, x2, x3, x4,
						y1, y2, y3, y4,
						z1, z2, z3, z4},
				ad=new float[]{
						1,1,1,0,
						x1, x2, x3, x5-x4,
						y1, y2, y3, y5-y4,
						z1, z2, z3, z5-z4};
		
		/**Determinants**/
		float dn=determ(an), dd=determ(ad);
		
		float t=-dn/dd;
		x = x4+(x5-x4)*t;
		y = y4+(y5-y4)*t;
		z = z4+(z5-z4)*t;
		return new Point3DFloat(x, y, z);
	}
	
	public static float determ(float[] m)
	{
		float sd[]=new float[16];
		
		sd[0] = m[5]  * m[10] * m[15] - 
				m[5]  * m[11] * m[14] - 
				m[9]  * m[6]  * m[15] + 
				m[9]  * m[7]  * m[14] +
				m[13] * m[6]  * m[11] - 
				m[13] * m[7]  * m[10];
		
		sd[4] = -m[4]  * m[10] * m[15] + 
				m[4]  * m[11] * m[14] + 
				m[8]  * m[6]  * m[15] - 
				m[8]  * m[7]  * m[14] - 
				m[12] * m[6]  * m[11] + 
				m[12] * m[7]  * m[10];
		
		sd[8] = m[4]  * m[9] * m[15] - 
				m[4]  * m[11] * m[13] - 
				m[8]  * m[5] * m[15] + 
				m[8]  * m[7] * m[13] + 
				m[12] * m[5] * m[11] - 
				m[12] * m[7] * m[9];
		
		sd[12] = -m[4]  * m[9] * m[14] + 
				m[4]  * m[10] * m[13] +
				m[8]  * m[5] * m[14] - 
				m[8]  * m[6] * m[13] - 
				m[12] * m[5] * m[10] + 
				m[12] * m[6] * m[9];
		
		return m[0] * sd[0] + m[1] * sd[4] + m[2] * sd[8] + m[3] * sd[12];
	}
}