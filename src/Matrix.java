public class Matrix{
	
	float[][] nullMatrix(int n) {
		float [][] M = new float[n][n];
		return M;
	}
	
	float[][] identityMatrix(int n) {
		float [][] M = nullMatrix(n);
		for(int j = 0; j<n; j++) {
			M[j][j]=1;
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
	
}
