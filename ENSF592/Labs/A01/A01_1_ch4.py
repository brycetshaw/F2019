import turtle
import math

def polyline(t, n, length, angle):
    for i in range(n):
        t.fd(length)
        t.lt(angle)

def square(t,length):
    polygon(t,length,4)

def polygon(t,length,n):
    for i in range(n):
        t.fd(length)
        t.lt(360/n)

def circle(t,r):
    arc(t,r,360)

def arc(t,r,angle):
    n=int(r*2)+3
    stepLength = r*(2*math.pi/n*abs(angle)/360)
    stepAngle = angle/n
    polyline(t,n,stepLength, stepAngle)
  

bob = turtle.Turtle()
square(bob,10)
polygon(bob,20,12)
circle(bob,10)
arc(bob,25,270)
print(bob)
turtle.mainloop()

""" By reading chapter 4, I learned to create python functions, 
a methodology to write and then refactor code, and how to make
an electronic turle follow instructions. I also learned about
triple quotations. """