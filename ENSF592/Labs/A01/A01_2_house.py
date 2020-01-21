import turtle
import math

def square(t,side):
    for i in range(4):
        t.fd(side)
        t.lt(90)

def drawHyp(t,side):
    bob.fd(side*(2**0.5))
    bob.lt(90)

def drawNonHyp(t,side):
    bob.fd(side/(2**0.5))
    bob.lt(90)

bob = turtle.Turtle()
side = 80


square(bob,side)
bob.lt(45)
drawHyp(bob,side)
drawNonHyp(bob,side)
drawNonHyp(bob,side)
drawHyp(bob,side)

turtle.mainloop()