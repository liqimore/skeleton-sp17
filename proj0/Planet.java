public class Planet {

	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;


	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	public Planet(Planet p){

		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double dx = p.xxPos - this.xxPos;
		double dy = p.yyPos - this.yyPos;
		double r2 = dx*dx + dy*dy; //r^2
		return Math.sqrt(r2);
	}

	/* F(1,x) */
	public double calcForceExertedByX(Planet p){
		double dx = p.xxPos - this.xxPos;
		double dy = p.yyPos - this.yyPos;
		double r = calcDistance(p);
		double F = (6.67e-11 * this.mass * p.mass) / (r*r);
		double F1x = (F * dx) / r;
		if (this.mass > p.mass) {
			return -F1x;
		}
		return F1x;
	}

	/* F(1,y) */
	public double calcForceExertedByY(Planet p){
		double dx = p.xxPos - this.xxPos;
		double dy = p.yyPos - this.yyPos;
		double r = calcDistance(p);
		double F = (6.67e-11 * this.mass * p.mass) / (r*r);
		double F1y = (F * dy) / r;
		if (this.mass > p.mass) {
			return -F1y;
		}
		return F1y;
	}

	/* net force X */
	public double calcNetForceExertedByX(Planet[] ps){
		double netForceX = 0;
		for (int i = 0; i < ps.length; i++) {
			netForceX += this.calcForceExertedByX(ps[i]);
		}
		return netForceX;
	}

	/* net force Y */
	public double calcNetForceExertedByY(Planet[] ps){
		double netForceY = 0;
		for (int i = 0; i < ps.length; i++) {
			netForceY += this.calcForceExertedByY(ps[i]);
		}
		return netForceY;
	}

	/* change position */
	public void update(double dt, double fX, double fY ){
		double aX = fX / this.mass;
		double aY = fY / this.mass;

		double nVX = this.xxVel + dt * aX;
		double nVY = this.yyVel + dt * aY;
		this.xxVel = nVX;
		this.yyVel = nVY;
		this.xxPos = this.xxPos + dt * nVX;
		this.yyPos = this.yyPos + dt * nVY;
	}


}
