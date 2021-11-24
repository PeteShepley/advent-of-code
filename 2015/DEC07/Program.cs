using System;
using System.Collections.Generic;
using System.IO;
using System.Runtime.InteropServices.ComTypes;
using System.Threading.Tasks;

namespace DEC07
{
    class Program
    {
        private static Dictionary<string, string> wires = new();
        private static Dictionary<string, int> calculated = new();
        static string[] ReadInput(string fileName)
        {
            return File.ReadAllLines(fileName);
        }

        static int Traverse(string key)
        {
            if (calculated.ContainsKey(key))
            {
                return calculated[key];
            }
            
            if (int.TryParse(key, out var result))
            {
                return result;
            }
            
            var instruction = wires[key];
            var tokens = instruction.Split(" ");
            
            var value = tokens.Length switch
            {
                1 => Traverse(tokens[0]),
                2 when tokens[0] == "NOT" => ~Traverse(tokens[1]),
                3 when tokens[1] == "LSHIFT" => Traverse(tokens[0]) << Traverse(tokens[2]),
                3 when tokens[1] == "RSHIFT" => Traverse(tokens[0]) >> Traverse(tokens[2]),
                3 when tokens[1] == "AND" => Traverse(tokens[0]) & Traverse(tokens[2]),
                3 when tokens[1] == "OR" => Traverse(tokens[0]) | Traverse(tokens[2]),
                _ => 0
            };
            
            calculated.Add(key, value);
            return value;
        }

        static void Main()
        {
            var lookup = "a";
            var fileName = @"C:\Users\petes\workspace\github.com\PeteShepley\advent-of-code\2015\DEC07\input";

            string[] lines;
            if (fileName != "")
            {
                lines = ReadInput(fileName);
            }
            else
            {
                lines = new[]
                {
                    "123 -> x",
                    "456 -> y",
                    "x AND y -> d",
                    "x OR y -> e",
                    "x LSHIFT 2 -> f",
                    "y RSHIFT 2 -> g",
                    "NOT x -> h",
                    "NOT y -> i"
                };
            }
            
            foreach (var line in lines)
            {
                var tokens = line.Split(" -> ");
                wires.Add(tokens[1], tokens[0]);
            }

            Console.WriteLine($"{Traverse(lookup)}");
        }
    }
}