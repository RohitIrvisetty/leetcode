function hammingWeight(n: number): number {
    let num: number[] = n.toString(2).split("").map(x => Number(x));
    let numNoZero: number[] = num.filter(x => x !== 0);
    return (numNoZero).length;
};