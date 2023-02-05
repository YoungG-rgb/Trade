import Link from 'next/link'

const NotFound = () => {
    return (
        <div className='flex flex-col items-center pt-[50px]'>
            <h1 className='not-italic font-normal text-[42px] leading-[50px] text-center text-[#000000] mb-[24px]'>Oops, Something <br/> Went Wrong</h1>
            <img className='w-[450px]' src="/notFound/notFound.svg" alt="404"/>
            <button className='mt-[52px] not-italic font-normal leading-[12px] text-[14px] text-white py-[22px] px-[31px] bg-[#735CFF] rounded-[5px]' type='button'>Return to Homepage</button>
        </div>
    )
}

export default NotFound;