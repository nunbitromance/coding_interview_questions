using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CrackingTheCodingInterview
{
    public enum Color
    {
        Blue = 0,
        Red,
        Green,
        Yello
    }

    public class Q_PaintFill
    {
        /*static void Main(string[] args)
        {
            var canvas = new Color[3, 3];
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j<3; j++)
                {
                    canvas[i, j] = Color.Yello;
                }
            }
            canvas[1, 1] = Color.Red;

            Paint(Color.Red, Color.Blue, canvas, 1, 1);
        }*/

        public static void Paint(Color oldColor, Color newColor, Color[,] canvas, int x, int y)
        {
            if (x < 0 || x > canvas.Length ||
                y < 0 || y > canvas.Rank)
            {
                return;
            }
            else
            {
                if (canvas[y, x] == oldColor)
                {
                    canvas[y, x] = newColor;

                    Paint(oldColor, newColor, canvas, x - 1, y);
                    Paint(oldColor, newColor, canvas, x, y + 1);
                    Paint(oldColor, newColor, canvas, x + 1, y);
                    Paint(oldColor, newColor, canvas, x, y - 1);
                }
            }
        }
    }
}
