# PackPlanner
PackPlanner is a prototype built as a part of interview process for software engineer position.

Application akes as standard input the max pack weight, max items per pack and a list of items.  As output it returns a list of packs.

Input Format
    
    [Sort order] [max pieces per pack] [max weight per pack]
    [item id],[item length],[item quantity],[piece weight]
    [item id],[item length],[item quantity],[piece weight]
    [item id],[item length],[item quantity],[piece weight]

Output format:

    Pack number: [pack number]
    [item id],[item length],[item quantity],[piece weight]
    [item id],[item length],[item quantity],[piece weight]
    ...
    Pack Length: [pack length], Pack Weight: [pack weight]

STD input example: (input ends when an empty line is received or you reach the end of the input stream)
    
    NATURAL,40,500.0
    1001,6200,30,9.653
    2001,7200,50,11.21

Example output for the above input:

    Pack Number: 1
    1001,6200,30,9.653
    2001,7200,10,11.21
    Pack Length: 7200, Pack Weight: 401.69

    Pack Number: 2
    2001,7200,40,11.21
    Pack Length: 7200, Pack Weight: 448.4
