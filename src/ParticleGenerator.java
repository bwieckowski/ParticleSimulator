import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ParticleGenerator {

    private static Vector2D getRandomVector(Surface surface){
        double x,y;

        do{
            x = Math.floor(Math.random()*surface.getWidth());
            y = Math.floor(Math.random()*surface.getHeight());
        }while(x > surface.getWidth() && y > surface.getHeight());

        return new Vector2D(x,y);
    }

    private static Vector2D getRandomSpeed(){
        int x,y;
        Random random = new Random();
        int max = 5;
        int min = -5;
        do {
            x = random.nextInt(max - min) + min;
            y = random.nextInt(max - min) + min;
        }while((x > -1|| x < -1) && (y > -1 || y < -1) );
        return new Vector2D(x,y);
    }

   public static ArrayList<Particle> generateParticles( Surface surface, int n ){

       ArrayList<Particle> particles = new ArrayList<Particle>();
       for( int i = 0; i < n; i++){
          Vector2D position = getRandomVector(surface);
          Vector2D speed = getRandomSpeed();
          Random r = new Random();
          Color color = new Color(r.nextInt(255 ),r.nextInt(100 ) ,r.nextInt(255 ));
          Particle p = new Particle(position, speed, 0.4);
          p.setColor(color);
          particles.add( p );

       }

       return particles;
   }
}
