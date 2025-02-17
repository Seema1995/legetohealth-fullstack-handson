import logo from './logo.svg';
import './App.css';
import {Route , Link , Routes} from 'react-router-dom'
import Greetings,{Hello} from './components/Greetings'
import Button,{Simple, Input} from './components/Button'
import Counter from './components/Counter'
import Person,{DisplayInfo} from './components/Person'
import {EmployeeItems, EmployeeUpdate,EmployeeById, EmployeeStoreForm} from './components/EmployeeCRUD'

function App(){
  // let message = "Hi, Hope you are having a good day."
  // let profile = {name : "Jim Corbett",age:68,dob: new Date(1962,10,20)}

  //Greetings/Hello Impl
  // return (
  //   <div>
  //     <h1> Welcome to React - Sharing the data from one component to another component using FUNCTIONS</h1>
  //     <Welcome message = {message} />
  //     <User profile = {profile} />
  //     <Hello name = {profile.name} />
  //     <Greetings firstname ="Seema" lastname ="Patil" />
  //   </div>
  // )

  //Button Impl
  // return (
  //   <div>
  //     <h1> Welcome to React - Sharing the data from one component to another component using FUNCTIONS</h1>
  //     <Button  />
  //     <Input  />
  //     <Simple />
  //   </div>
  // )

  //Counter Impl
  // return (
  //     <div>
  //       <h1> Welcome to React - Sharing the data from one component to another component using FUNCTIONS</h1>
  //       <Counter />
  //     </div>
  //   )

  //ActivityReact Impl
  // return (
  //   <div>
  //     <Person />
      
  //   </div>
  // )


  //EmployeeStoreForm Impl
  // return (
  //   <div className ="container-fluid">
  //      <h1 className = "text-center">Employee Form Bootstrap-react tutorial</h1>
  //      <EmployeeStoreForm />
  //      <hr></hr>
  //      <EmployeeItems />
  //  </div>
  // )

  //EmployeeCRUD Impl
  // return (
  //   <div className ="container-fluid">
  //     <h1 className = "text-center">Bootstrap-react tutorial</h1>
  //     <EmployeeItems />
  //   </div>
  // )

  //React Router DOM Impl
  return (
    <div className="container-fluid">
      <h1> Welcome to React-Router-DOM tutorial</h1>
      <div className="row">
        <div className="col-5">
          <Navigation />
        </div>
      </div>
      <div className="row">
        <div className="col-5">
          <Routes>
            <Route path = '/' element = {<EmployeeItems />} />
            <Route path = '/store' element = {<EmployeeStoreForm />} />
            <Route path = '/fetchAll' element = {<EmployeeItems />} />
            <Route path = '/fetchById' element = {<EmployeeById />} />
            <Route path = '/update' element = {<EmployeeUpdate />} />
          </Routes>
        </div>
      </div>
    </div>
  )

}

function Navigation(){
  return (
    <div className="alert alert-secondary">
      <Link to = './store'>Store Employee</Link>|
      <Link to = './fetchById'>Search By ID</Link>  |
      <Link to = './fetchAll'>Fetch All Employees</Link> |
      <Link to = './update'>Update Employee</Link>
    </div>
  )
}

function User(props){
  // let profile = props.profile
  // profile.Name   profile.Age  profile.DOB

  //OR
  return (
    <div>
      <h3>Name : {props.profile.name}, Age : {props.profile.age},DOB :{props.profile.dob.toLocaleDateString()}</h3>
    </div>
  )
}

function Welcome(props){
  return(
    <div>
      <h3>
        {props.message}
      </h3>
    </div>
  )
}

export default App;
