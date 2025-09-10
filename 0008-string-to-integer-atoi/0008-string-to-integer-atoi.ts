function myAtoi(s: string): number {
    let output: number = parseInt(s) < (Math.pow(2, 31) - 1) ? parseInt(s) : Math.pow(2,31) -1;
    output = parseInt(s) > -1 * Math.pow(2, 31) ? output : -1 * Math.pow(2, 31);
    return parseInt(s) ? output : 0;
};