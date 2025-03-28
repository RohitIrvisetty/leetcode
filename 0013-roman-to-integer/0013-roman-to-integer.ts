function romanToInt(s: string): number {
    const romanMapping: Map<string, number> = new Map([
        ['I', 1],
        ['V', 5],
        ['X', 10],
        ['L', 50],
        ['C', 100],
        ['D', 500],
        ['M', 1000]
    ]);
    let output = 0;
    for (let i = 0; i < s.length; i++) {
        let currentInteger = romanMapping.get(s[i]);
        let nextInteger = romanMapping.get(s[i+1]);
        console.log(nextInteger);
        if (nextInteger && currentInteger < nextInteger) {
            output += (nextInteger - currentInteger);
            i++;
        } else {
            output += currentInteger;
        }
    }
    return output;
};