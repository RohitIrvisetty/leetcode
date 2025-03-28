function reverse(x: number): number {
    let sign: number = x > 0 ? 1 : -1;
    let output: number = (Math.pow(2,31)-1) > (sign * Number((sign * x).toString().split("").reverse().join(""))) ? sign * Number((sign * x).toString().split("").reverse().join("")) : 0; 
    return -1 * Math.pow(2,31) < output ? output : 0;
};