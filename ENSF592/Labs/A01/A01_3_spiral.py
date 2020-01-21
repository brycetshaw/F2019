import turtle
import math

def polyline(t, n, length, angle):
    for i in range(n):
        t.fd(length)
        t.lt(angle)

def arc(t,r,angle):
    n=10
    stepLength = r*(2*math.pi/n*abs(angle)/360)
    stepAngle = angle/n
    polyline(t,n,stepLength, stepAngle)

def draw_spiral(t, n, angle):
    
    k= 0.1
    a = 4*10*3*2
    for i in range(n):
      r = a * math.atan(0.000+ k * i * angle * math.pi / 180)
      arc(bob, r, angle)

bob = turtle.Turtle()  
n =   45
draw_spiral(bob,n, 90)
turtle.mainloop()


