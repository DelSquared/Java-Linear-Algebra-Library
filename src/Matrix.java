import java.lang.Math;
public class Matrix{
	
	float[][] nullMatrix(int n) {
		float [][] M = new float[n][n];
		return M;
	}
	
	float[][][] nullTensor(int n) {
		float [][][] M = new float[n][n][n];
		return M;
	}
	
	float[][] identityMatrix(int n) {
		float [][] M = nullMatrix(n);
		for(int j = 0; j<n; j++) {
			M[j][j]=1;
		}
		return M;
	}
	
	float[][][] identityTensor(int n) {
		float [][][] M = nullTensor(n);
		for(int j = 0; j<n; j++) {
			M[j][j][j]=1;
		}
		return M;
	}
	
	float[] nullVector(int n) {
		float [] v = new float[n];
		for(int i = 0; i<n; i++) {
			v[i]=0;
		}
		return v;
	}
	
	float dot(float[] a, float[] b) {
		float s=0;
		if (a.length==b.length) {
			for (int i = 0; i<a.length; i++) {
				s += a[i]*b[i];
			}
		}
		else {
			System.out.println("Vector dimension mismatch");
		}
		return s;
	}
	
	float[] cross3D(float[] a, float[] b) {
		float[] c= new float[3];
		if (a.length==b.length) {
			if (a.length==3) {
				c[0] = a[1]*b[2]-b[1]*a[2];
				c[1] = -(a[0]*b[2]-b[0]*a[2]);
				c[2] = a[0]*b[1]-b[0]*a[1];
			}
			else {
				System.out.println("This function only accepts 3D vectors");
			}
		}
		else {
			System.out.println("Vector dimension mismatch");
		}
		return c;
	}
	
	float[] rotate2D(float[] a, float t) {
		float[]b = new float[2];
		if (a.length==2) {
			float[]x = new float[2];
			float[]y = new float[2];
			
			x[0] = (float) Math.cos(t);
			x[1] = (float) Math.sin(t);
			y[0] = (float) Math.sin(-t);
			y[1] = (float) Math.cos(t);
			
			b[0] = dot(x,a);
			b[1] = dot(y,a);
		}
		else {
			System.out.println("Vector is not 2D");
		}
		return b;
	}
	
	float det2D(float[][] a) {
		float d=0;
		if (a.length==2 && a[0].length==2) {
			d = a[0][0]*a[1][1] - a[0][1]*a[1][0];
		}
		else {
			System.out.println("Matrix not 2D");
		}
		return d;
	}
	
	float tr(float[][] a) {
		float d=0;
		if (a.length==a[0].length) {
			for (int i=0;i<a.length;i++) {
				d +=a[i][i];
			}
		}
		else {
			System.out.println("Matrix not square");
		}
		return d;
	}
	
	float[][] add(float[][] a, float[][] b) {
		float [][] M = new float[a.length][a[0].length];
		if (a.length==b.length && a[0].length==b[0].length) {
			for(int i = 0; i<a.length; i++) {
				for(int j = 0; j<a[0].length; j++) {
					M[i][j]=a[i][j]+b[i][j];
				}
			}
		}
		else {
			System.out.println("Matrices don't match");
		}
		return M;
	}
	
	float[][] multiply(float[][] a, float[][] b) {
		float [][] M = new float[a.length][b[0].length];
		if (a[0].length==b.length) {
			for(int i = 0; i<a.length; i++) {
				for(int j = 0; j<b[0].length; j++) {
					for(int k = 0; k<b.length; k++) {
						M[i][j] += a[i][k]*b[k][j];
					}
				}
			}
		}
		else {
			System.out.println("Matrices don't match");
		}
		return M;
	}
	
	float[][] scale(float[][] a, float s) {
		for(int i = 0; i<a.length; i++) {
			for(int j = 0; j<a[0].length; j++) {
				if (a[i][j] == 0) {
					a[i][j] = 0;
				}
				else {
					a[i][j] *= s;
				}
			}
		}
		return a;
	}
	
	float[][] transpose(float[][] a) {
		float [][] M = new float[a[0].length][a.length];
		for(int i = 0; i<a[0].length; i++) {
			for(int j = 0; j<a.length; j++) {
				M[i][j] = a[j][i];
			}
		}
		return M;
	}
	
	float[]eigenvals2D(float[][]a){
		float[]spec = new float[2];
		if (a.length==2 && a[0].length==2) {
			float d = (float)((double)0.5*Math.sqrt((double)(tr(a)*tr(a)-4*det2D(a))));
			float b = (float)0.5*tr(a);
			spec[0] = b+d;
			spec[1] = b-d;
		}
		else {
			System.out.println("Matrix not 2D");
		}
		return spec;
	}
	
	float[][] symmetrise(float[][] a) {
		float [][] M = new float[a.length][a.length];
		if (a.length==a[0].length) {
			M = scale(add(a,transpose(a)),(float)0.5);
		}
		else {
			System.out.println("Matrix not square");
		}
		return M;
	}
	
	float[][] antisymmetrise(float[][] a) {
		float [][] M = new float[a.length][a.length];
		if (a.length==a[0].length) {
			M = scale(add(a,scale(transpose(a),-1)),(float)0.5);
		}
		else {
			System.out.println("Matrix not square");
		}
		return M;
	}
	
	float[] transformVector(float[][]a, float[]x) {
		float[] y = new float[x.length];
		if(a[0].length==x.length) {
			for(int i=0;i<x.length;i++) {
				y[i]=dot(a[i],x);
			}
		}
		else {
			System.out.println("Dimension mismatch");
		}
		return y;
	}

}
