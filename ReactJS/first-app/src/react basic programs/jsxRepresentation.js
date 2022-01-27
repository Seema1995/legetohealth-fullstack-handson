
//The below is an example of React element. 
//React uses these objects and uses them to construct the DOM and keep it up to date

const element = (<h1 className="greeting">
                Hello World!
                </h1>)

//Above code is internally rendered as -
//const element = React.createElement(
//                  'h1',
//                  {className: 'greeting'},
//                  'Hello World!')

//Final conversion looks like this -
// const element ={
//     type: 'h1',
//     props: {
//         className: 'greeting',
//         children: 'Hello, world!'
//     }
// }